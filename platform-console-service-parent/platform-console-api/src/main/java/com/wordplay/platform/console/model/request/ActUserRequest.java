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
@ApiModel("工作流用户请求参数")
public class ActUserRequest extends BaseEntityRequest {

	private static final long serialVersionUID = 1150489199923115839L;

	@ApiModelProperty("firstName")
	private String firstName;

	@ApiModelProperty("firstName")
	private String lastName;

	@ApiModelProperty("email")
	private String email;

	@ApiModelProperty("密码")
	private String password;

}
