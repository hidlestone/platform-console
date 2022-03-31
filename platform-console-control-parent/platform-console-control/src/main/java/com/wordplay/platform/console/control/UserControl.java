package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.UserClient;
import com.wordplay.platform.console.model.request.UserQueryReq;
import com.wordplay.platform.console.model.response.UserResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "用户管理")
@RestController
@RequestMapping("/${platform.console.control.version}/user")
public class UserControl {

	@Autowired
	private UserClient userClient;

	@GetMapping("/get")
	@ApiOperation(value = "查询用户")
	public ResponseResult<UserResponse> get(@RequestParam Long id) {
		return userClient.get(id);
	}

	@PostMapping("/list")
	@ApiOperation(value = "分页查询用户")
	public ResponseResult<Leaf<UserResponse>> list(@RequestBody UserQueryReq req) {
		return userClient.list(req);
	}

}
