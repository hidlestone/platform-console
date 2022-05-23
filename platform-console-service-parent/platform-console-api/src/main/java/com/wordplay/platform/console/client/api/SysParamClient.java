package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.SysParamItemRequest;
import com.wordplay.platform.console.model.response.SysParamItemResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 系统参数
 *
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/sysparam")
public interface SysParamClient {

	@PostMapping("/save")
	ResponseResult save(@RequestBody SysParamItemRequest request);

	@PostMapping("/delete")
	ResponseResult delete(@RequestParam String code);

	@PostMapping("/update")
	ResponseResult update(@RequestBody SysParamItemRequest request);

	@GetMapping("/getitemsbygroupcode")
	ResponseResult<List<SysParamItemResponse>> getItemsByGroupCode(@RequestParam String groupCode);

	@GetMapping("/get")
	ResponseResult<SysParamItemResponse> get(@RequestParam String code);

	@PostMapping("/list")
	ResponseResult<Leaf<SysParamItemResponse>> list(@RequestParam SysParamItemRequest request);
}
