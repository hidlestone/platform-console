package com.wordplay.platform.console.client.impl;

import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.VerifyCodeClient;
import com.wordplay.platform.console.model.request.VerifyCodeSenderRequest;
import com.wordplay.platform.console.service.VerifyCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 验证码
 *
 * @author zhuangpf
 */
@Api(tags = "验证码")
@RestController
@RequestMapping("/${platform.console.service.version}/verifycode")
public class VerifyCodeClientImpl implements VerifyCodeClient {

	@Autowired
	private VerifyCodeService verifyCodeService;

	@Override
	@PostMapping("/sendverifycode")
	@ApiOperation("发送随机的验证码")
	public ResponseResult sendVerifyCode(VerifyCodeSenderRequest request) {
		return verifyCodeService.sendVerifyCode(request);
	}

}
