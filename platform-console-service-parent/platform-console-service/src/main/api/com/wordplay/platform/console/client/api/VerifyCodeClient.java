package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.VerifyCodeSenderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 验证码
 *
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/verifycode")
public interface VerifyCodeClient {

	ResponseResult sendVerifyCode(@RequestBody VerifyCodeSenderRequest request);

}
