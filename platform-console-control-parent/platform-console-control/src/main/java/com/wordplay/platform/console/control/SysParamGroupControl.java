package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.SysParamGroupClient;
import com.wordplay.platform.console.model.request.SysParamGroupQueryRequest;
import com.wordplay.platform.console.model.response.SysParamGroupResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "系统参数组")
@RestController
@RequestMapping("/${platform.console.control.version}/sysparamgroup")
public class SysParamGroupControl {

	@Autowired
	private SysParamGroupClient sysParamGroupClient;

	@GetMapping("/get")
	@ApiOperation(value = "根据配置组编码查询配置组及明细项")
	public ResponseResult<SysParamGroupResponse> get(@RequestParam String code) {
		return sysParamGroupClient.get(code);
	}

	@PostMapping("/list")
	@ApiOperation(value = "分页查询配置组")
	public ResponseResult<Leaf<SysParamGroupResponse>> list(@RequestBody SysParamGroupQueryRequest request) {
		return sysParamGroupClient.list(request);
	}

}
