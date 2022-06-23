package com.wordplay.platform.console.client.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.data.mp.util.LeafPageUtil;
import com.fallframework.platform.starter.wechatwork.entity.Department;
import com.fallframework.platform.starter.wechatwork.service.DepartmentService;
import com.wordplay.platform.console.client.api.WxWorkDepartmentClient;
import com.wordplay.platform.console.model.request.WxWorkDepartmentRequest;
import com.wordplay.platform.console.model.response.WxWorkDepartmentResponse;
import com.wordplay.platform.console.model.response.DictDtlResponse;
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
@Api(tags = "企微-通讯录-部门")
@RestController
@RequestMapping("/${platform.console.service.version}/wxworkdepartment")
public class WxWorkDepartmentClientImpl implements WxWorkDepartmentClient {

	@Autowired
	private DepartmentService departmentService;

	@Override
	@GetMapping("/get")
	@ApiOperation("查询部门")
	public ResponseResult<WxWorkDepartmentResponse> get(@RequestParam Long id) {
		Department department = departmentService.getById(id);
		WxWorkDepartmentResponse response = new WxWorkDepartmentResponse();
		BeanUtils.copyProperties(department, response);
		return ResponseResult.success(response);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation("分页查询部门")
	public ResponseResult<Leaf<WxWorkDepartmentResponse>> list(@RequestBody WxWorkDepartmentRequest request) {
		Department department = new Department();
		BeanUtils.copyProperties(request, department);
		Page<Department> page = departmentService.list(department).getData();
		Leaf leaf = LeafPageUtil.pageToLeaf(page, DictDtlResponse.class);
		return ResponseResult.success(leaf);
	}

	@Override
	@PostMapping("/getdepartmenttree")
	@ApiOperation("查询部门树")
	public ResponseResult<List<WxWorkDepartmentResponse>> getDepartmentTree(@RequestBody WxWorkDepartmentRequest request) {
		Department department = new Department();
		BeanUtils.copyProperties(request, department);
		List<Department> departmentList = departmentService.getDepartmentTree(department).getData();
		List<WxWorkDepartmentResponse> wxWorkDepartmentResponseList = JSON.parseArray(JSON.toJSONString(departmentList), WxWorkDepartmentResponse.class);
		return ResponseResult.success(wxWorkDepartmentResponseList);
	}

}
