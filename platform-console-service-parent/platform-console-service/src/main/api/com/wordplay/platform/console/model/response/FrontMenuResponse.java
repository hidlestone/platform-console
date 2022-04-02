package com.wordplay.platform.console.model.response;

import com.fallframework.platform.starter.api.response.BaseEntityResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 数据结构如下：
 *
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel("PC端前端菜单响应参数")
public class FrontMenuResponse extends BaseEntityResponse {

	private static final long serialVersionUID = 7489037462873487580L;

	@ApiModelProperty("跳转路径")
	private String path;

	@ApiModelProperty("加载的页面组件")
	private String component;

	@ApiModelProperty("重定向路径")
	private String redirect;

	@ApiModelProperty("是否显示")
	private Boolean alwaysShow;

	@ApiModelProperty("菜单名称")
	private String name;

	@ApiModelProperty("菜单明细信息")
	private MenuMetaInfoResponse meta;

	@ApiModelProperty("子菜单")
	private List<FrontMenuResponse> children;

	// 数据结构：
	/*
		path: '/permission',
		component: Layout,
		redirect: '/permission/page',
		alwaysShow: true, // will always show the root menu
		name: 'Permission',
		meta: {
		  title: 'Permission',
		  icon: 'lock',
		  roles: ['admin', 'editor'] // you can set roles in root nav
		},
		children: [
		  {
			path: 'page',
			component: () => import('@/views/permission/page'),
			name: 'PagePermission',
			meta: {
			  title: 'Page Permission',
			  roles: ['admin'] // or you can only set roles in sub nav
			}
		  },
		  {
			path: 'directive',
			component: () => import('@/views/permission/directive'),
			name: 'DirectivePermission',
			meta: {
			  title: 'Directive Permission'
			  // if do not set roles, means: this page does not require permission
			}
		  },
		  {
			path: 'role',
			component: () => import('@/views/permission/role'),
			name: 'RolePermission',
			meta: {
			  title: 'Role Permission',
			  roles: ['admin']
			}
		  }
		]
	  }
	* */

}
