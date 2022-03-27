package com.wordplay.platform.console.client.impl;

import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.cache.redis.util.RedisUtil;
import com.fallframework.platform.starter.core.util.EncryptionUtil;
import com.fallframework.platform.starter.rbac.entity.User;
import com.fallframework.platform.starter.rbac.model.TokenTypeEnum;
import com.fallframework.platform.starter.shiro.constant.ShiroStarterConstant;
import com.fallframework.platform.starter.shiro.util.JWTUtil;
import com.wordplay.platform.console.client.api.LoginClient;
import com.wordplay.platform.console.model.AccountPwdLoginRequest;
import com.wordplay.platform.console.model.LoginSuccessResponse;
import com.wordplay.platform.console.model.QRCodeLoginRequest;
import com.wordplay.platform.console.model.VerificationCodeLoginRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author zhuangpf
 */
@Api(tags = "用户登录")
@RestController
@RequestMapping("/${platform.console.service.version}/login")
public class LoginClientImpl implements LoginClient {

	@Autowired
	private JWTUtil jwtUtill;
	@Autowired
	private RedisUtil redisUtil;

	@Override
	@PostMapping("/loginbyaccount")
	@ApiOperation(value = "账号密码登录")
	public ResponseResult<LoginSuccessResponse> loginByAccount(@RequestBody AccountPwdLoginRequest request, HttpServletResponse response) {
		if ((StringUtils.isBlank(request.getAccount()) && StringUtils.isBlank(request.getTel()))
				|| StringUtils.isBlank(request.getPassword())) {
			return ResponseResult.fail("账号密码不能为空");
		}
		// 执行登录
		Subject currentUser = SecurityUtils.getSubject();
		String md5pwd = EncryptionUtil.encryptMD5(request.getPassword());
		String account = StringUtils.isNoneBlank(request.getAccount()) ? request.getAccount() : request.getTel();
		try {
			UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(account, md5pwd);
			currentUser.login(usernamePasswordToken);
		} catch (UnknownAccountException e) {
			return ResponseResult.fail("account or passwordis not correct.");
		} catch (LockedAccountException e) {
			return ResponseResult.fail("account is disable, contact the admin.");
		}
		User curUser = (User) currentUser.getPrincipal();
		String accesstoken = jwtUtill.createToken(curUser, TokenTypeEnum.ACCESSTOKEN);
		String refreshtoken = jwtUtill.createToken(curUser, TokenTypeEnum.REFRESHTOKEN);
		redisUtil.set(ShiroStarterConstant.CACHE_KEY_SHIRO_ACCESSTOKEN + curUser.getId(), accesstoken);
		redisUtil.set(ShiroStarterConstant.CACHE_KEY_SHIRO_REFRESHTOKEN + curUser.getId(), refreshtoken);
		// 返回token信息
		LoginSuccessResponse resp = new LoginSuccessResponse();
		resp.setAccesstoken(accesstoken);
		resp.setRefreshtoken(refreshtoken);
		// 在返回的请求头中设置token信息
		response.setHeader("accesstoken", accesstoken);
		response.setHeader("refreshtoken", refreshtoken);
		return ResponseResult.success(resp);
	}

	@Override
	@PostMapping("/loginbyverificationcode")
	@ApiOperation(value = "账号验证码登录")
	public ResponseResult loginByVerificationCode(VerificationCodeLoginRequest request) {
		return null;
	}

	@Override
	@PostMapping("/loginbyqrcodelogin")
	@ApiOperation(value = "扫二维码登录")
	public ResponseResult loginByQRCodeLogin(QRCodeLoginRequest request) {
		return null;
	}

}
