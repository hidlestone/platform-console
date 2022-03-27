package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.AccountPwdLoginRequest;
import com.wordplay.platform.console.model.LoginSuccessResponse;
import com.wordplay.platform.console.model.QRCodeLoginRequest;
import com.wordplay.platform.console.model.VerificationCodeLoginRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 用户登录
 *
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/login")
public interface LoginClient {

	@PostMapping("/loginbyaccount")
	ResponseResult<LoginSuccessResponse> loginByAccount(@RequestBody AccountPwdLoginRequest request, HttpServletResponse response);

	@PostMapping("/loginbyverificationcode")
	ResponseResult loginByVerificationCode(@RequestBody VerificationCodeLoginRequest request);

	@PostMapping("/loginbyqrcodelogin")
	ResponseResult loginByQRCodeLogin(@RequestBody QRCodeLoginRequest request);


}
