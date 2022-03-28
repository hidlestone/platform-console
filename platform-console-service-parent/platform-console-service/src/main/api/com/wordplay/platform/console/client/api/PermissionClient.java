package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.PermissionReq;
import com.wordplay.platform.console.model.response.PermissionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 接口权限管理
 *
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/permission")
public interface PermissionClient {

	@PostMapping("/save")
	ResponseResult save(@RequestBody PermissionReq request);

	@PostMapping("/delete")
	ResponseResult delete(@RequestParam Long id);

	@PostMapping("/update")
	ResponseResult update(@RequestBody PermissionReq request);

	@GetMapping("/get")
	ResponseResult<PermissionResponse> get(@RequestParam Long id);

	@PostMapping("/list")
	ResponseResult<Leaf<PermissionResponse>> list(@RequestBody PermissionReq req);

}
