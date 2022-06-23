package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.WxWorkDepartmentRequest;
import com.wordplay.platform.console.model.response.WxWorkDepartmentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 企微-通讯录-部门
 *
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/wxworkdepartment")
public interface WxWorkDepartmentClient {

	@GetMapping("/get")
	ResponseResult<WxWorkDepartmentResponse> get(@RequestParam Long id);

	@PostMapping("/list")
	ResponseResult<Leaf<WxWorkDepartmentResponse>> list(@RequestBody WxWorkDepartmentRequest request);

	@PostMapping("/getdepartmenttree")
	ResponseResult<List<WxWorkDepartmentResponse>> getDepartmentTree(@RequestBody WxWorkDepartmentRequest request);
	
}
