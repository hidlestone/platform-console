package com.wordplay.platform.console.client.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.data.mp.util.LeafPageUtil;
import com.fallframework.platform.starter.wechatwork.entity.User;
import com.fallframework.platform.starter.wechatwork.service.UserService;
import com.wordplay.platform.console.client.api.WxWorkUserClient;
import com.wordplay.platform.console.model.request.WxWorkUserRequest;
import com.wordplay.platform.console.model.response.WxWorkUserResponse;
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

/**
 * @author zhuangpf
 */
@Api(tags = "企微-通讯录-部门-成员")
@RestController
@RequestMapping("/${platform.console.service.version}/wxworkuser")
public class WxWorkUserClientImpl implements WxWorkUserClient {

	@Autowired
	private UserService userService;

	@Override
	@GetMapping("/get")
	@ApiOperation("查询部门成员")
	public ResponseResult<WxWorkUserResponse> get(@RequestParam Long id) {
		User user = userService.getById(id);
		WxWorkUserResponse response = new WxWorkUserResponse();
		BeanUtils.copyProperties(user, response);
		return ResponseResult.success(response);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation("分页查询部门成员")
	public ResponseResult<Leaf<WxWorkUserResponse>> list(@RequestBody WxWorkUserRequest request) {
		User user = new User();
		BeanUtils.copyProperties(request, user);
		Page<User> page = userService.list(user).getData();
		Leaf leaf = LeafPageUtil.pageToLeaf(page, WxWorkUserResponse.class);
		return ResponseResult.success(leaf);
	}

	@Override
	@GetMapping("/getusersbydeptid")
	@ApiOperation("根据部门ID查询成员")
	public ResponseResult<List<WxWorkUserResponse>> getUsersByDeptId(Long deptId) {
		List<User> userList = userService.getUsersByDeptId(deptId).getData();
		List<WxWorkUserResponse> wxWorkUserResponseList = JSON.parseArray(JSON.toJSONString(userList), WxWorkUserResponse.class);
		return ResponseResult.success(wxWorkUserResponseList);
	}
	
}
