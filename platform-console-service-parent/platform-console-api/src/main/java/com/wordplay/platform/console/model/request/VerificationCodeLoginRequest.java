package com.wordplay.platform.console.model.request;

import com.fallframework.platform.starter.api.request.BaseEntityRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel("验证码登录请求参数")
public class VerificationCodeLoginRequest extends BaseEntityRequest {

	private static final long serialVersionUID = 6705756052231780747L;

	@ApiModelProperty("用户账号")
	private String account;

	@ApiModelProperty("电话号码")
	private String tel;

	@ApiModelProperty("验证码")
	private String verificationCode;

}
