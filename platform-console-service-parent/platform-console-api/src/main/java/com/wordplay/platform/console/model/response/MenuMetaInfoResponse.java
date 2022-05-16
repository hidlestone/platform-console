package com.wordplay.platform.console.model.response;

import com.fallframework.platform.starter.api.response.BaseEntityResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * meta: {
 * title: 'Permission',
 * icon: 'lock',
 * roles: ['admin', 'editor'] // you can set roles in root nav
 * }
 *
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel("PC端前端菜单明细响应参数")
public class MenuMetaInfoResponse extends BaseEntityResponse {

	private static final long serialVersionUID = 2715294974504464497L;

	@ApiModelProperty("标题")
	private String title;

	@ApiModelProperty("图标")
	private String icon;

	@ApiModelProperty("可访问的角色")
	private List<String> roles;

}
