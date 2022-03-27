package com.wordplay.platform.console.client.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.rbac.entity.Role;
import com.fallframework.platform.starter.rbac.model.RoleRequest;
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
	ResponseResult save(@RequestBody RoleRequest request);

	@PostMapping("/delete")
	ResponseResult delete(@RequestParam Long id);

	@PostMapping("/update")
	ResponseResult update(@RequestBody RoleRequest request);

	@GetMapping("/get")
	ResponseResult<Role> get(@RequestParam Long id);

	@PostMapping("/list")
	ResponseResult<Page<Role>> list(@RequestBody RoleRequest request);

	@GetMapping("/getrolesbyuserid")
	List<Role> getRolesByUserId(@RequestParam Long userId);
	
}
