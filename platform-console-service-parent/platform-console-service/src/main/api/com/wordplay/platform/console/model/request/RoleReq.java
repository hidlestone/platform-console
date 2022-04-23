package com.wordplay.platform.console.model.request;

import com.fallframework.platform.starter.api.request.BasePageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel("角色请求参数")
public class RoleReq extends BasePageRequest {

	private static final long serialVersionUID = 4243904600353181565L;

	@ApiModelProperty("主键")
	private Long id;

	@NotNull(message = "角色编码不能为空")
	@ApiModelProperty("角色编码")
	private String roleCode;

	@NotNull(message = "角色名称不能为空")
	@ApiModelProperty("角色名称")
	private String roleName;

	@NotNull(message = "角色描述不能为空")
	@ApiModelProperty("角色描述")
	private String roleDesc;

	@NotNull(message = "角色关联的菜单不能为空")
	@ApiModelProperty("角色关联的菜单")
	private List<MenuReq> menuReqList;

}
