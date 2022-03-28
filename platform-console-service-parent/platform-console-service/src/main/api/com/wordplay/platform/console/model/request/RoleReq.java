package com.wordplay.platform.console.model.request;

import com.fallframework.platform.starter.api.request.BasePageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhuangpf
 */
@ApiModel("角色请求参数")
public class RoleReq extends BasePageRequest {

	private static final long serialVersionUID = 4243904600353181565L;

	@ApiModelProperty("主键")
	private Long id;

	@ApiModelProperty("角色编码")
	private String roleCode;

	@ApiModelProperty("角色名称")
	private String roleName;

	@ApiModelProperty("角色描述")
	private String roleDesc;

}
