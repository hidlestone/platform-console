package com.wordplay.platform.console.model.response;

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
@ApiModel("工作流用户响应参数")
public class ActUserResponse extends BaseEntityRequest {

	private static final long serialVersionUID = 9105932234769059537L;

	@ApiModelProperty("firstName")
	private String firstName;

	@ApiModelProperty("firstName")
	private String lastName;

	@ApiModelProperty("email")
	private String email;

	@ApiModelProperty("密码")
	private String password;

	@ApiModelProperty("用户其他信息")
	private ByteArrayRef pictureByteArrayRef;
	
}
