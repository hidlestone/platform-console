package com.wordplay.platform.console.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.ReUtil;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.cache.redis.util.RedisUtil;
import com.fallframework.platform.starter.mail.model.MailSendInfoRequest;
import com.fallframework.platform.starter.mail.service.PlatformMailSender;
import com.fallframework.platform.starter.rbac.constant.RbacStarterConstant;
import com.wordplay.platform.console.model.enums.VerifyCodeSenderEnum;
import com.wordplay.platform.console.model.request.VerifyCodeSenderRequest;
import com.wordplay.platform.console.service.VerifyCodeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

/**
 * @author zhuangpf
 */
@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {

	private static final Pattern HK_TEL_PATTERN = Pattern.compile("^(5|6|8|9)\\d{7}$");
	private static final Pattern CHINA_TEL_PATTERN = Pattern.compile("^((13[0-9])|(14[0,1,4-9])|(15[0-3,5-9])|(16[2,5,6,7])|(17[0-8])|(18[0-9])|(19[0-3,5-9]))\\d{8}$");
	private static final Pattern MAIL_PATTERN = Pattern.compile("^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$");

	@Autowired
	private PlatformMailSender platformMailSender;
	@Autowired
	private RedisUtil redisUtil;

	@Override
	public ResponseResult sendVerifyCode(VerifyCodeSenderRequest request) {
		ResponseResult validateResp = this.sendVerifyCodeValidate(request);
		if (!validateResp.isSuccess()) {
			return validateResp;
		}
		// 生成四位随机的验证码
		String randomVerifyCode = RandomUtil.randomNumbers(4);
		// 发送邮件
		if (VerifyCodeSenderEnum.MAIL.equals(request.getVerifyCodeSender())) {
			// TODO 发送模板邮件
			MailSendInfoRequest infoRequest = new MailSendInfoRequest();
			platformMailSender.sendTemplateEmail(infoRequest);

		} else {
			// TODO 发送模板短信
		}
		String key = StringUtils.isNotEmpty(request.getTel()) ? request.getTel() : request.getMailAddress();
		// 存储到缓存中。user:verificationcode:{业务类型}:{tel/mail}
		String cachekey = RbacStarterConstant.CACHE_KEY_USER_VERIFICATIONCODE + request.getVerifyCodeType().name().toLowerCase() + ":" + key;
		redisUtil.set(cachekey, randomVerifyCode, 5 * 60);// 默认可用时间5分钟
		return ResponseResult.success();
	}

	/**
	 * 数据校验
	 *
	 * @param request 请求参数
	 * @return 是否校验通过
	 */
	private ResponseResult sendVerifyCodeValidate(VerifyCodeSenderRequest request) {
		if (null == request.getVerifyCodeSender()) {
			return ResponseResult.fail("验证码发送方式不能为空");
		}
		if (null == request.getVerifyCodeType()) {
			return ResponseResult.fail("业务类型不能为空");
		}
		if (VerifyCodeSenderEnum.TEL.equals(request.getVerifyCodeSender())) {
			if (StringUtils.isEmpty(request.getTel())) {
				return ResponseResult.fail("号码不能为空");
			}
			// 号码正则校验
			if (!ReUtil.isMatch(CHINA_TEL_PATTERN, request.getTel())) {
				return ResponseResult.fail("号码格式错误");
			}
		}
		if (VerifyCodeSenderEnum.MAIL.equals(request.getVerifyCodeSender())) {
			if (StringUtils.isEmpty(request.getMailAddress())) {
				return ResponseResult.fail("邮箱地址不能为空");
			}
			if (!ReUtil.isMatch(MAIL_PATTERN, request.getMailAddress())) {
				return ResponseResult.fail("邮箱格式错误");
			}
		}
		return ResponseResult.success();
	}

}
