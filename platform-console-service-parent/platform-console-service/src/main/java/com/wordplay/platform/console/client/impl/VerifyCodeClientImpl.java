package com.wordplay.platform.console.client.impl;

import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.VerifyCodeClient;
import com.wordplay.platform.console.model.request.VerifyCodeSenderRequest;
import com.wordplay.platform.console.service.VerifyCodeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 验证码
 *
 * @author zhuangpf
 */
public class VerifyCodeClientImpl implements VerifyCodeClient {

	@Autowired
	private VerifyCodeService verifyCodeService;
	
	@Override
	public ResponseResult sendVerifyCode(VerifyCodeSenderRequest request) {
		return verifyCodeService.sendVerifyCode(request);
	}

}
