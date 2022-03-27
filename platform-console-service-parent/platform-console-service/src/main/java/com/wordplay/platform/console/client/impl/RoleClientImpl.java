package com.wordplay.platform.console.client.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.rbac.entity.Role;
import com.fallframework.platform.starter.rbac.model.RoleRequest;
import com.fallframework.platform.starter.rbac.service.RoleService;
import com.wordplay.platform.console.client.api.RoleClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhuangpf
 */
@Api(tags = "角色管理")
@RestController
@RequestMapping("/${platform.console.service.version}/role")
public class RoleClientImpl implements RoleClient {

	@Autowired
	private RoleService roleService;

	@Override
	@PostMapping("/save")
	@ApiOperation(value = "保存角色")
	public ResponseResult save(RoleRequest request) {
		Role role = new Role();
		BeanUtils.copyProperties(request, role);
		roleService.save(role);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/delete")
	@ApiOperation(value = "删除角色")
	public ResponseResult delete(Long id) {
		roleService.removeById(id);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/update")
	@ApiOperation(value = "修改角色")
	public ResponseResult update(RoleRequest request) {
		Role role = new Role();
		BeanUtils.copyProperties(request, role);
		roleService.updateById(role);
		return ResponseResult.success();
	}

	@Override
	@GetMapping("/get")
	@ApiOperation(value = "查询角色")
	public ResponseResult<Role> get(Long id) {
		Role role = roleService.getById(id);
		return ResponseResult.success(role);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation(value = "分页查询角色")
	public ResponseResult<Page<Role>> list(RoleRequest request) {
		return roleService.list(request);
	}

	@Override
	@GetMapping("/getrolesbyuserid")
	@ApiOperation(value = "根据用户ID查询角色")
	public List<Role> getRolesByUserId(@RequestParam Long userId) {
		return roleService.getRolesByUserId(userId);
	}


}
