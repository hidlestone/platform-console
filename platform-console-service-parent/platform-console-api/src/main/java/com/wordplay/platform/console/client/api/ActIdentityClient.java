package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.ActGroupRequest;
import com.wordplay.platform.console.model.request.ActUserRequest;
import com.wordplay.platform.console.model.request.GroupQueryRequest;
import com.wordplay.platform.console.model.request.SaveUserAndGroupRequest;
import com.wordplay.platform.console.model.request.UserQueryRequest;
import com.wordplay.platform.console.model.response.ActGroupResponse;
import com.wordplay.platform.console.model.response.ActUserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/actidentity")
public interface ActIdentityClient {

	/**
	 * 保存用户
	 *
	 * @param request 用户
	 * @return 是否保存成功
	 */
	@PostMapping("/saveuser")
	ResponseResult saveUser(@RequestBody ActUserRequest request);

	/**
	 * 删除用户
	 *
	 * @param request 用户信息
	 * @return 是否删除成功
	 */
	@PostMapping("/deleteuser")
	ResponseResult deleteUser(@RequestBody ActUserRequest request);

	/**
	 * 根据用户ID查询用户
	 *
	 * @param userId 用户ID
	 * @return 用户信息
	 */
	@GetMapping("/getuser")
	ResponseResult<ActUserResponse> getUser(@RequestParam String userId);

	/**
	 * 分页查询用户信息
	 *
	 * @param request 请求参数
	 * @return 用户分页
	 */
	@PostMapping("/getuserlist")
	ResponseResult<Leaf<ActUserResponse>> getUserList(@RequestBody UserQueryRequest request);

	/**
	 * 添加组（角色）
	 *
	 * @param request 用户组
	 * @return 是否添加成功红
	 */
	@PostMapping("/savegroup")
	ResponseResult saveGroup(@RequestBody ActGroupRequest request);

	/**
	 * 删除用户组
	 *
	 * @param request 用户组
	 * @return 是否删除成功
	 */
	@PostMapping("/deletegroup")
	ResponseResult deleteGroup(@RequestBody ActGroupRequest request);

	/**
	 * 根据用户组ID查询用户组
	 *
	 * @param groupId 用户组ID
	 * @return 用户信息
	 */
	@GetMapping("/getgroup")
	ResponseResult<ActGroupResponse> getGroup(@RequestParam String groupId);

	/**
	 * 分页查询用户组
	 *
	 * @param request 请求参数
	 * @return 用户组分页
	 */
	@PostMapping("/getgrouplist")
	ResponseResult<Leaf<ActGroupResponse>> getGroupList(@RequestBody GroupQueryRequest request);

	/**
	 * 保存用户和用户组之间的关系
	 *
	 * @param userId  用户ID
	 * @param groupId 用户组ID
	 * @return 是否保存成功
	 */
	@GetMapping("/saveusergroupmemership")
	ResponseResult saveUserGroupMemership(@RequestParam String userId, @RequestParam String groupId);

	/**
	 * 保存用户&用户组&关系
	 *
	 * @param request 请求参数
	 * @return 是否保存成功
	 */
	@PostMapping("/saveuserandgroup")
	ResponseResult saveUserAndGroup(@RequestBody SaveUserAndGroupRequest request);

}
