package com.wordplay.platform.console.client.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.rbac.entity.User;
import com.fallframework.platform.starter.rbac.model.UserQueryRequest;
import com.fallframework.platform.starter.rbac.service.UserService;
import com.wordplay.platform.console.client.api.UserClient;
import com.wordplay.platform.console.model.request.UserQueryReq;
import com.wordplay.platform.console.model.response.UserResponse;
import com.wordplay.platform.console.util.LeafPageUtil;
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
@Api(tags = "用户管理")
@RestController
@RequestMapping("/${platform.console.service.version}/user")
public class UserClientImpl implements UserClient {

	@Autowired
	private UserService userService;

	@Override
	@GetMapping("/get")
	@ApiOperation(value = "查询用户")
	public ResponseResult<UserResponse> get(@RequestParam Long id) {
		User user = userService.getById(id);
		UserResponse response = new UserResponse();
		BeanUtils.copyProperties(user, response);
		return ResponseResult.success(response);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation(value = "分页查询用户")
	public ResponseResult<Leaf<UserResponse>> list(@RequestBody UserQueryReq req) {
		UserQueryRequest request = new UserQueryRequest();
		BeanUtils.copyProperties(req, request);
		Page<User> page = userService.list(request).getData();
		Leaf leaf = LeafPageUtil.pageToLeaf(page, UserResponse.class);
		return ResponseResult.success(leaf);
	}

}
