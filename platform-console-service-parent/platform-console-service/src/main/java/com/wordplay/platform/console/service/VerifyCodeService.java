package com.wordplay.platform.console.service;

import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.VerifyCodeSenderRequest;

/**
 * @author zhuangpf
 */
public interface VerifyCodeService {

	ResponseResult sendVerifyCode(VerifyCodeSenderRequest request);

}
