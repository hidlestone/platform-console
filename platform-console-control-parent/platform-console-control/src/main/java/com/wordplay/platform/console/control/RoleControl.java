package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.RoleClient;
import com.wordplay.platform.console.model.request.RoleReq;
import com.wordplay.platform.console.model.response.RoleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/role")
public class RoleControl {

	@Autowired
	private RoleClient roleClient;

	@PostMapping("/save")
	@ApiOperation(value = "保存角色")
	public ResponseResult save(RoleReq req) {
		return roleClient.save(req);
	}

	@PostMapping("/delete")
	@ApiOperation(value = "删除角色")
	public ResponseResult delete(Long id) {
		return roleClient.delete(id);
	}

	@PostMapping("/update")
	@ApiOperation(value = "修改角色")
	public ResponseResult update(RoleReq req) {
		return roleClient.update(req);
	}

	@GetMapping("/get")
	@ApiOperation(value = "查询角色")
	public ResponseResult<RoleResponse> get(Long id) {
		return roleClient.get(id);
	}

	@PostMapping("/list")
	@ApiOperation(value = "分页查询角色")
	public ResponseResult<Leaf<RoleResponse>> list(RoleReq req) {
		return roleClient.list(req);
	}

	@GetMapping("/getrolesbyuserid")
	@ApiOperation(value = "根据用户ID查询角色")
	public ResponseResult<List<RoleResponse>> getRolesByUserId(@RequestParam Long userId) {
		return roleClient.getRolesByUserId(userId);
	}
	
}
