package com.wordplay.platform.console.client.impl;

import com.alibaba.fastjson.JSON;
import com.fallframework.platform.starter.activiti.model.GroupQueryDto;
import com.fallframework.platform.starter.activiti.model.SaveUserAndGroupDto;
import com.fallframework.platform.starter.activiti.model.UserQueryDto;
import com.fallframework.platform.starter.activiti.service.ActIdentityService;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.ActIdentityClient;
import com.wordplay.platform.console.model.request.ActGroupRequest;
import com.wordplay.platform.console.model.request.ActUserRequest;
import com.wordplay.platform.console.model.request.GroupQueryRequest;
import com.wordplay.platform.console.model.request.SaveUserAndGroupRequest;
import com.wordplay.platform.console.model.request.UserQueryRequest;
import com.wordplay.platform.console.model.response.ActGroupResponse;
import com.wordplay.platform.console.model.response.ActUserResponse;
import com.wordplay.platform.console.util.LeafPageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuangpf
 */
@Api(tags = "流程任务")
@RestController
@RequestMapping("/${platform.console.service.version}/actidentity")
public class ActIdentityClientImpl implements ActIdentityClient {

	@Autowired
	private ActIdentityService actIdentityService;

	@Override
	@PostMapping("/saveuser")
	@ApiOperation("保存用户")
	public ResponseResult saveUser(ActUserRequest request) {
		User user = JSON.parseObject(JSON.toJSONString(request), User.class);
		return actIdentityService.saveUser(user);
	}

	@Override
	@PostMapping("/deleteuser")
	@ApiOperation("删除用户")
	public ResponseResult deleteUser(ActUserRequest request) {
		User user = JSON.parseObject(JSON.toJSONString(request), User.class);
		return actIdentityService.deleteUser(user);
	}

	@Override
	@GetMapping("/getuser")
	@ApiOperation("根据用户ID查询用户")
	public ResponseResult<ActUserResponse> getUser(String userId) {
		User user = actIdentityService.getUser(userId).getData();
		ActUserResponse actUserResponse = JSON.parseObject(JSON.toJSONString(user), ActUserResponse.class);
		return ResponseResult.success(actUserResponse);
	}

	@Override
	@PostMapping("/getuserlist")
	@ApiOperation("分页查询用户信息")
	public ResponseResult<Leaf<ActUserResponse>> getUserList(UserQueryRequest request) {
		UserQueryDto dto = new UserQueryDto();
		BeanUtils.copyProperties(request, dto);
		Leaf<User> page = actIdentityService.getUserList(dto).getData();
		Leaf leaf = LeafPageUtil.leafToType(page, ActUserResponse.class);
		return ResponseResult.success(leaf);
	}

	@Override
	@PostMapping("/savegroup")
	@ApiOperation("添加组（角色）")
	public ResponseResult saveGroup(ActGroupRequest request) {
		Group group = JSON.parseObject(JSON.toJSONString(request), Group.class);
		return actIdentityService.saveGroup(group);
	}

	@Override
	@PostMapping("/deletegroup")
	@ApiOperation("删除用户组")
	public ResponseResult deleteGroup(ActGroupRequest request) {
		Group group = JSON.parseObject(JSON.toJSONString(request), Group.class);
		return actIdentityService.deleteGroup(group);
	}

	@Override
	@PostMapping("/getgroup")
	@ApiOperation("根据用户组ID查询用户组")
	public ResponseResult<ActGroupResponse> getGroup(String groupId) {
		Group group = actIdentityService.getGroup(groupId).getData();
		ActGroupResponse actGroupResponse = JSON.parseObject(JSON.toJSONString(group), ActGroupResponse.class);
		return ResponseResult.success(actGroupResponse);
	}

	@Override
	@PostMapping("/getgrouplist")
	@ApiOperation("分页查询用户组")
	public ResponseResult<Leaf<ActGroupResponse>> getGroupList(GroupQueryRequest request) {
		GroupQueryDto dto = new GroupQueryDto();
		BeanUtils.copyProperties(request, dto);
		Leaf<Group> page = actIdentityService.getGroupList(dto).getData();
		Leaf leaf = LeafPageUtil.leafToType(page, ActGroupResponse.class);
		return ResponseResult.success(leaf);
	}

	@Override
	@GetMapping("/saveusergroupmemership")
	@ApiOperation("保存用户和用户组之间的关系")
	public ResponseResult saveUserGroupMemership(String userId, String groupId) {
		return actIdentityService.saveUserGroupMemership(userId, groupId);
	}

	@Override
	@GetMapping("/saveuserandgroup")
	@ApiOperation("保存用户和用户组之间的关系")
	public ResponseResult saveUserAndGroup(SaveUserAndGroupRequest request) {
		SaveUserAndGroupDto dto = new SaveUserAndGroupDto();
		BeanUtils.copyProperties(request, dto);
		return actIdentityService.saveUserAndGroup(dto);
	}
	
}
