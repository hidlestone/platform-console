package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.RoleReq;
import com.wordplay.platform.console.model.response.RoleResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 角色管理
 *
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/role")
public interface RoleClient {

	@PostMapping("/save")
	ResponseResult save(@RequestBody RoleReq req);

	@PostMapping("/delete")
	ResponseResult delete(@RequestParam Long id);

	@PostMapping("/update")
	ResponseResult update(@RequestBody RoleReq req);

	@GetMapping("/get")
	ResponseResult<RoleResponse> get(@RequestParam Long id);

	@PostMapping("/list")
	ResponseResult<Leaf<RoleResponse>> list(@RequestBody RoleReq req);

	@GetMapping("/getrolesbyuserid")
	ResponseResult<List<RoleResponse>> getRolesByUserId(@RequestParam Long userId);

	@PostMapping("/getallrole")
	ResponseResult<List<RoleResponse>> getAllRole();

}
