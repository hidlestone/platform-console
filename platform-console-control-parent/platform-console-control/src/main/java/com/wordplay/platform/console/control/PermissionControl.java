package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.PermissionClient;
import com.wordplay.platform.console.model.request.PermissionReq;
import com.wordplay.platform.console.model.response.PermissionResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuangpf
 */
@Api(tags = "接口权限管理")
@RestController
@RequestMapping("/permission")
public class PermissionControl {

	@Autowired
	private PermissionClient permissionClient;

	@PostMapping("/save")
	@ApiOperation(value = "保存接口权限")
	public ResponseResult save(@RequestBody PermissionReq request) {
		return permissionClient.save(request);
	}

	@PostMapping("/delete")
	@ApiOperation(value = "删除接口权限")
	public ResponseResult delete(Long id) {
		return permissionClient.delete(id);
	}

	@PostMapping("/update")
	@ApiOperation(value = "修改接口权限")
	public ResponseResult update(@RequestBody PermissionReq req) {
		return permissionClient.update(req);
	}

	@GetMapping("/get")
	@ApiOperation(value = "查询接口权限")
	public ResponseResult<PermissionResponse> get(Long id) {
		return permissionClient.get(id);
	}

	@PostMapping("/list")
	@ApiOperation(value = "分页查询接口权限")
	public ResponseResult<Leaf<PermissionResponse>> list(@RequestBody PermissionReq req) {
		return permissionClient.list(req);
	}

}