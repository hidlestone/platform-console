package com.wordplay.platform.console.client.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.cache.redis.util.RedisUtil;
import com.fallframework.platform.starter.rbac.constant.RbacStarterConstant;
import com.fallframework.platform.starter.rbac.entity.Role;
import com.fallframework.platform.starter.rbac.entity.User;
import com.fallframework.platform.starter.rbac.service.RoleService;
import com.fallframework.platform.starter.rbac.service.UserService;
import com.fallframework.platform.starter.rbac.util.RequestContexUtil;
import com.fallframework.platform.starter.shiro.util.JWTUtil;
import com.wordplay.platform.console.client.api.UserClient;
import com.wordplay.platform.console.model.request.UserRequest;
import com.wordplay.platform.console.model.response.UserDtlInfoResponse;
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

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhuangpf
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/${platform.console.service.version}/user")
public class UserClientImpl implements UserClient {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private JWTUtil jwtUtil;

	@Override
	@GetMapping("/get")
	@ApiOperation("查询用户")
	public ResponseResult<UserResponse> get(@RequestParam Long id) {
		User user = userService.getById(id);
		UserResponse response = new UserResponse();
		BeanUtils.copyProperties(user, response);
		return ResponseResult.success(response);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation("分页查询用户")
	public ResponseResult<Leaf<UserResponse>> list(@RequestBody UserRequest request) {
		User user = new User();
		BeanUtils.copyProperties(request, user);
		Page<User> page = userService.list(user).getData();
		Leaf leaf = LeafPageUtil.pageToLeaf(page, UserResponse.class);
		return ResponseResult.success(leaf);
	}

	@Override
	@GetMapping("/getuserinfo")
	@ApiOperation("根据accessToken获取用户信息")
	public ResponseResult<UserDtlInfoResponse> getUserInfo() {
		String accesstoken = RequestContexUtil.getAccesstoken();
		User model = null;
		try {
			model = jwtUtil.parseToken(accesstoken);
			if (null == model) {
				return ResponseResult.fail("用户不存在");
			}
		} catch (Exception e) {
			return ResponseResult.fail("当前token不可用，请重新登录");
		}
		User user = userService.getById(model.getId());
		UserDtlInfoResponse response = new UserDtlInfoResponse();
		BeanUtils.copyProperties(user, response);
		response.setIntroduction(user.getRemark());
		// 角色信息
		List<Role> roleList = roleService.getRolesByUserId(model.getId());
		if (CollectionUtil.isEmpty(roleList)) {
			return ResponseResult.fail("当前用户角色信息不存在");
		}
		List<String> roles = roleList.stream().map(e -> e.getRoleCode()).distinct().collect(Collectors.toList());
		response.setRoles(roles);
		return ResponseResult.success(response);
	}

	@Override
	@GetMapping("/logout")
	@ApiOperation("用户登出")
	public ResponseResult logout(@RequestParam String accesstoken) {
		User model = null;
		try {
			model = jwtUtil.parseToken(accesstoken);
			if (null == model) {
				return ResponseResult.fail("用户不存在");
			}
		} catch (Exception e) {
			return ResponseResult.fail("token不可用");
		}
		// 删除缓存中的token
		redisUtil.del(RbacStarterConstant.CACHE_KEY_ACCESSTOKEN + model.getId());
		redisUtil.del(RbacStarterConstant.CACHE_KEY_REFRESHTOKEN + model.getId());
		return ResponseResult.success();
	}

}
