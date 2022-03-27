package com.wordplay.platform.console.model;

import com.fallframework.platform.starter.api.request.BaseEntityRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhuangpf
 */
@ApiModel(value = "验证码登录请求参数")
public class VerificationCodeLoginRequest extends BaseEntityRequest {

	private static final long serialVersionUID = 6705756052231780747L;

	@ApiModelProperty(value = "用户账号")
	private String account;

	@ApiModelProperty(value = "电话号码")
	private String tel;

	@ApiModelProperty(value = "验证码")
	private String verificationCode;

}
