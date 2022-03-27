package com.wordplay.platform.console.client.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.rbac.entity.User;
import com.fallframework.platform.starter.rbac.model.UserQueryRequest;
import com.fallframework.platform.starter.rbac.service.UserService;
import com.wordplay.platform.console.client.api.UserClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuangpf
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserClientImpl implements UserClient {

	@Autowired
	private UserService userService;

	@Override
	@GetMapping("/get")
	@ApiOperation(value = "查询用户")
	public ResponseResult<User> get(Long id) {
		User user = userService.getById(id);
		return ResponseResult.success(user);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation(value = "分页查询用户")
	public ResponseResult<Page<User>> list(UserQueryRequest request) {
		return userService.list(request);
	}
	
}
