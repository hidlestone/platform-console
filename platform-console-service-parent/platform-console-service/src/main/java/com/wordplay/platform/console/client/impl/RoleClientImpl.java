package com.wordplay.platform.console.client.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.rbac.entity.Role;
import com.fallframework.platform.starter.rbac.entity.RoleMenu;
import com.fallframework.platform.starter.rbac.model.RoleRequest;
import com.fallframework.platform.starter.rbac.service.RoleMenuService;
import com.fallframework.platform.starter.rbac.service.RolePermissionService;
import com.fallframework.platform.starter.rbac.service.RoleService;
import com.wordplay.platform.console.client.api.RoleClient;
import com.wordplay.platform.console.model.request.MenuReq;
import com.wordplay.platform.console.model.request.RoleReq;
import com.wordplay.platform.console.model.response.RoleResponse;
import com.wordplay.platform.console.util.LeafPageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuangpf
 */
@Validated
@Api(tags = "角色管理")
@RestController
@RequestMapping("/${platform.console.service.version}/role")
public class RoleClientImpl implements RoleClient {

	@Autowired
	private RoleService roleService;
	@Autowired
	private RoleMenuService roleMenuService;
	@Autowired
	private RolePermissionService rolePermissionService;

	@Override
	@PostMapping("/save")
	@ApiOperation(value = "保存角色及菜单关联")
	public ResponseResult<RoleResponse> save(@Validated @RequestBody RoleReq req) {
		Role role = new Role();
		BeanUtils.copyProperties(req, role);
		roleService.save(role);
		// 保存菜单关联
		List<RoleMenu> roleMenuList = getRoleMenuList(role.getId(), req);
		roleMenuService.saveBatch(roleMenuList);
		RoleResponse roleResponse = new RoleResponse();
		BeanUtils.copyProperties(role, roleResponse);
		return ResponseResult.success(roleResponse);
	}

	public List<RoleMenu> getRoleMenuList(Long roleId, RoleReq req) {
		List<MenuReq> menuReqList = req.getMenuReqList();
		List<RoleMenu> roleMenuList = new ArrayList<>();
		for (MenuReq menuReq : menuReqList) {
			RoleMenu roleMenu = new RoleMenu();
			roleMenu.setRoleId(roleId);
			roleMenu.setMenuId(menuReq.getId());
			roleMenuList.add(roleMenu);
		}
		return roleMenuList;
	}

	@Override
	@PostMapping("/delete")
	@ApiOperation(value = "删除角色")
	public ResponseResult delete(@RequestParam Long id) {
		// 删除角色
		roleService.removeById(id);
		// 删除角色菜单
		QueryWrapper wrapper = new QueryWrapper();
		wrapper.eq("role_id", id);
		roleMenuService.remove(wrapper);
		// 删除角色权限
		rolePermissionService.remove(wrapper);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/update")
	@ApiOperation(value = "修改角色")
	public ResponseResult update(@RequestBody RoleReq req) {
		Role role = new Role();
		BeanUtils.copyProperties(req, role);
		roleService.updateById(role);
		// 删除原来角色菜单
		if (null == req.getId()) {
			return ResponseResult.fail("角色ID不能为空");
		}
		QueryWrapper wrapper = new QueryWrapper();
		wrapper.eq("role_id", req.getId());
		roleMenuService.remove(wrapper);
		// 新增角色菜单
		List<RoleMenu> roleMenuList = getRoleMenuList(role.getId(), req);
		roleMenuService.saveBatch(roleMenuList);
		return ResponseResult.success();
	}

	@Override
	@GetMapping("/get")
	@ApiOperation(value = "查询角色")
	public ResponseResult<RoleResponse> get(@RequestParam Long id) {
		Role role = roleService.getById(id);
		RoleResponse response = new RoleResponse();
		BeanUtils.copyProperties(response, response);
		return ResponseResult.success(response);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation(value = "分页查询角色")
	public ResponseResult<Leaf<RoleResponse>> list(@RequestBody RoleReq req) {
		RoleRequest request = new RoleRequest();
		BeanUtils.copyProperties(req, request);
		Page<Role> page = roleService.list(request).getData();
		Leaf leaf = LeafPageUtil.pageToLeaf(page, RoleResponse.class);
		return ResponseResult.success(leaf);
	}

	@Override
	@GetMapping("/getrolesbyuserid")
	@ApiOperation(value = "根据用户ID查询角色")
	public ResponseResult<List<RoleResponse>> getRolesByUserId(@RequestParam Long userId) {
		List<Role> roleList = roleService.getRolesByUserId(userId);
		List<RoleResponse> respList = JSON.parseArray(JSON.toJSONString(roleList), RoleResponse.class);
		return ResponseResult.success(respList);
	}

	@Override
	@PostMapping("/getallrole")
	@ApiOperation(value = "查询所有角色")
	public ResponseResult<List<RoleResponse>> getAllRole() {
		List<Role> roleList = roleService.getAllRole().getData();
		List<RoleResponse> roleResponseList = JSON.parseArray(JSON.toJSONString(roleList), RoleResponse.class);
		return ResponseResult.success(roleResponseList);
	}

}
