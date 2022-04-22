package com.wordplay.platform.console.model.response;

import com.fallframework.platform.starter.api.response.BaseEntityResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel("接口权限响应参数")
public class RoleResponse extends BaseEntityResponse {

	private static final long serialVersionUID = 646520292769514586L;

	@ApiModelProperty("角色编码")
	private String roleCode;

	@ApiModelProperty("角色名称")
	private String roleName;

	@ApiModelProperty("角色描述")
	private String roleDesc;
	
}
