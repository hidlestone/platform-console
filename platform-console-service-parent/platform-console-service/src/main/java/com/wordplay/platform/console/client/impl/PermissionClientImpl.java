package com.wordplay.platform.console.client.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.data.mp.util.LeafPageUtil;
import com.fallframework.platform.starter.rbac.entity.Permission;
import com.fallframework.platform.starter.rbac.service.PermissionService;
import com.wordplay.platform.console.client.api.PermissionClient;
import com.wordplay.platform.console.model.request.PermissionRequest;
import com.wordplay.platform.console.model.response.PermissionResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuangpf
 */
@Api(tags = "接口权限管理")
@RestController
@RequestMapping("/${platform.console.service.version}/permission")
public class PermissionClientImpl implements PermissionClient {

	@Autowired
	private PermissionService permissionService;

	@Override
	@PostMapping("/save")
	@ApiOperation("保存接口权限")
	public ResponseResult save(@RequestBody PermissionRequest request) {
		Permission permission = new Permission();
		BeanUtils.copyProperties(request, permission);
		permissionService.save(permission);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/delete")
	@ApiOperation("删除接口权限")
	public ResponseResult delete(@RequestParam Long id) {
		permissionService.removeById(id);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/update")
	@ApiOperation("修改接口权限")
	public ResponseResult update(@RequestBody PermissionRequest request) {
		Permission permission = new Permission();
		BeanUtils.copyProperties(request, permission);
		permissionService.updateById(permission);
		return ResponseResult.success();
	}

	@Override
	@GetMapping("/get")
	@ApiOperation("查询接口权限")
	public ResponseResult<PermissionResponse> get(@RequestParam Long id) {
		Permission permission = permissionService.getById(id);
		PermissionResponse response = new PermissionResponse();
		BeanUtils.copyProperties(permission, response);
		return ResponseResult.success(response);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation("分页查询接口权限")
	public ResponseResult<Leaf<PermissionResponse>> list(@RequestBody PermissionRequest request) {
		Permission permission = new Permission();
		BeanUtils.copyProperties(request, permission);
		Page<Permission> page = permissionService.list(permission).getData();
		Leaf leaf = LeafPageUtil.pageToLeaf(page, PermissionResponse.class);
		return ResponseResult.success(leaf);
	}

}
