package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.UserQueryReq;
import com.wordplay.platform.console.model.response.UserDtlInfoResponse;
import com.wordplay.platform.console.model.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户管理
 *
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/user")
public interface UserClient {

	@GetMapping("/get")
	ResponseResult<UserResponse> get(@RequestParam Long id);

	@PostMapping("/list")
	ResponseResult<Leaf<UserResponse>> list(@RequestBody UserQueryReq req);

	@GetMapping("/getuserinfo")
	ResponseResult<UserDtlInfoResponse> getUserInfo(@RequestParam String accesstoken);

}
