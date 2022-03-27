package com.wordplay.platform.console.model;

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
@ApiModel(value = "账号登录请求参数")
public class AccountPwdLoginRequest extends BaseEntityRequest {

	private static final long serialVersionUID = 7364824123402997223L;

	@ApiModelProperty(value = "用户账号")
	private String account;

	@ApiModelProperty(value = "电话号码")
	private String tel;
	
	@ApiModelProperty(value = "用户密码")
	private String password;
	
}
