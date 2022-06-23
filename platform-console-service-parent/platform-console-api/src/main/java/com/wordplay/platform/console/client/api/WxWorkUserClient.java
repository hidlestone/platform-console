package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.WxWorkUserRequest;
import com.wordplay.platform.console.model.response.WxWorkUserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 企微-通讯录-部门-成员
 *
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/wxworkuser")
public interface WxWorkUserClient {

	@GetMapping("/get")
	ResponseResult<WxWorkUserResponse> get(@RequestParam Long id);

	@PostMapping("/list")
	ResponseResult<Leaf<WxWorkUserResponse>> list(@RequestBody WxWorkUserRequest request);

	@GetMapping("/getusersbydeptid")
	ResponseResult<List<WxWorkUserResponse>> getUsersByDeptId(@RequestParam Long deptId);

}
