package com.wordplay.platform.console.model.response;

import com.fallframework.platform.starter.api.response.BaseEntityResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel("接口权限响应参数")
public class RoleResponse extends BaseEntityResponse {

	private static final long serialVersionUID = 646520292769514586L;

	@ApiModelProperty("主键")
	private Long id;

	@ApiModelProperty("角色编码")
	private String roleCode;

	@ApiModelProperty("角色名称")
	private String roleName;

	@ApiModelProperty("角色描述")
	private String roleDesc;

	@ApiModelProperty("创建用户ID")
	private Long createUserId;

	@ApiModelProperty("修改用户ID")
	private Long modifyUserId;

	@ApiModelProperty("创建时间")
	private Date gmtCreate;

	@ApiModelProperty("更改时间")
	private Date gmtModified;
	
}
