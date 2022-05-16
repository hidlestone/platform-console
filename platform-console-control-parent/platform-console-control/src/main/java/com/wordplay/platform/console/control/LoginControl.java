package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.LoginClient;
import com.wordplay.platform.console.model.AccPwdLoginRequest;
import com.wordplay.platform.console.model.request.AccountPwdLoginRequest;
import com.wordplay.platform.console.model.request.QRCodeLoginRequest;
import com.wordplay.platform.console.model.request.VerificationCodeLoginRequest;
import com.wordplay.platform.console.model.response.LoginSuccessResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuangpf
 */
@Api(tags = "用户登录")
@RestController
@RequestMapping("/${platform.console.control.version}/login")
public class LoginControl {

	@Autowired
	private LoginClient loginClient;

	@PostMapping("/loginbyaccount")
	@ApiOperation(value = "账号密码登录")
	public ResponseResult<LoginSuccessResponse> loginByAccount(@RequestBody AccPwdLoginRequest request1) {
		AccountPwdLoginRequest request = new AccountPwdLoginRequest();
		request.setAccount(request1.getUsername());
		request.setTel(request1.getTel());
		request.setPassword(request1.getPassword());
		return loginClient.loginByAccount(request);
	}

	@PostMapping("/loginbyverificationcode")
	@ApiOperation(value = "账号验证码登录")
	public ResponseResult loginByVerificationCode(VerificationCodeLoginRequest request) {
		return loginClient.loginByVerificationCode(request);
	}

	@PostMapping("/loginbyqrcodelogin")
	@ApiOperation(value = "扫二维码登录")
	public ResponseResult loginByQRCodeLogin(QRCodeLoginRequest request) {
		return loginClient.loginByQRCodeLogin(request);
	}

}
