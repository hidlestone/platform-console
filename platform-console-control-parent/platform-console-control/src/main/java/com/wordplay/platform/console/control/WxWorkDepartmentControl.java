package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.WxWorkDepartmentClient;
import com.wordplay.platform.console.model.request.WxWorkDepartmentRequest;
import com.wordplay.platform.console.model.response.WxWorkDepartmentResponse;
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
@Api(tags = "企微-通讯录-部门")
@RestController
@RequestMapping("/${platform.console.control.version}/wxworkdepartment")
public class WxWorkDepartmentControl {

	@Autowired
	private WxWorkDepartmentClient wxWorkDepartmentClient;

	@GetMapping("/get")
	@ApiOperation("查询部门")
	public ResponseResult<WxWorkDepartmentResponse> get(@RequestParam Long id) {
		return wxWorkDepartmentClient.get(id);
	}

	@PostMapping("/list")
	@ApiOperation("分页查询部门")
	public ResponseResult<Leaf<WxWorkDepartmentResponse>> list(@RequestBody WxWorkDepartmentRequest request) {
		return wxWorkDepartmentClient.list(request);
	}

	@PostMapping("/getdepartmenttree")
	@ApiOperation("查询部门树")
	public ResponseResult<List<WxWorkDepartmentResponse>> getDepartmentTree(@RequestBody WxWorkDepartmentRequest request) {
		return wxWorkDepartmentClient.getDepartmentTree(request);
	}

}
