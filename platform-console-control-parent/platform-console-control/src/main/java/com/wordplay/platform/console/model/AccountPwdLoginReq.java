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
@ApiModel("账号登录请求参数")
public class AccountPwdLoginReq extends BaseEntityRequest {

	private static final long serialVersionUID = -1867620935199084853L;
	
	@ApiModelProperty("用户名")
	private String username;

	@ApiModelProperty("电话号码")
	private String tel;

	@ApiModelProperty("用户密码")
	private String password;

}
