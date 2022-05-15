package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.config.entity.SysParamGroup;
import com.wordplay.platform.console.model.request.SysParamGroupQueryRequest;
import com.wordplay.platform.console.model.response.SysParamGroupResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/sysparamgroup")
public interface SysParamGroupClient {

	@GetMapping("/get")
	ResponseResult<SysParamGroupResponse> get(@RequestParam String code);

	@PostMapping("/list")
	ResponseResult<Leaf<SysParamGroupResponse>> list(@RequestBody SysParamGroupQueryRequest request);

}
