package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.DictDtlRequest;
import com.wordplay.platform.console.model.response.DictDtlResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/dictdtl")
public interface DictDtlClient {

	@PostMapping("/save")
	ResponseResult save(@RequestBody DictDtlRequest request);

	@PostMapping("/delete")
	ResponseResult delete(@RequestParam Long id);

	@PostMapping("/update")
	ResponseResult update(@RequestBody DictDtlRequest request);

	@GetMapping("/get")
	ResponseResult<DictDtlResponse> get(@RequestParam Long id);

	@GetMapping("/getdictdtlsbydictcode")
	ResponseResult<List<DictDtlResponse>> getDictDtlsByDictCode(@RequestParam String dictCode);

	@PostMapping("/list")
	ResponseResult<Leaf<DictDtlResponse>> list(@RequestBody DictDtlRequest request);

}
