package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.DictRequest;
import com.wordplay.platform.console.model.response.DictResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/dict")
public interface DictClient {

	@PostMapping("/savedict")
	ResponseResult saveDict(@RequestBody DictRequest request);

	@PostMapping("/delete")
	ResponseResult delete(@RequestParam Long id);

	@PostMapping("/update")
	ResponseResult update(@RequestBody DictRequest request);

	@GetMapping("/get")
	ResponseResult<DictResponse> get(@RequestParam Long id);

	@PostMapping("/list")
	ResponseResult<Leaf<DictResponse>> list(@RequestBody DictRequest request);

	@GetMapping("/getalldicts")
	ResponseResult<List<DictResponse>> getAllDicts();

}
