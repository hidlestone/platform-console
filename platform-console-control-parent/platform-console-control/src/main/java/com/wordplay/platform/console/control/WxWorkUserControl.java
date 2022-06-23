package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.WxWorkUserClient;
import com.wordplay.platform.console.model.request.WxWorkUserRequest;
import com.wordplay.platform.console.model.response.WxWorkUserResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/${platform.console.control.version}/wxworkuser")
public class WxWorkUserControl {

	@Autowired
	private WxWorkUserClient wxWorkUserClient;

	@GetMapping("/get")
	@ApiOperation("查询部门成员")
	public ResponseResult<WxWorkUserResponse> get(@RequestParam Long id) {
		return wxWorkUserClient.get(id);
	}

	@PostMapping("/list")
	@ApiOperation("分页查询部门成员")
	public ResponseResult<Leaf<WxWorkUserResponse>> list(@RequestBody WxWorkUserRequest request) {
		return wxWorkUserClient.list(request);
	}

	@GetMapping("/getusersbydeptid")
	@ApiOperation("根据部门ID查询成员")
	public ResponseResult<List<WxWorkUserResponse>> getUsersByDeptId(Long deptId) {
		return wxWorkUserClient.getUsersByDeptId(deptId);
	}

}
