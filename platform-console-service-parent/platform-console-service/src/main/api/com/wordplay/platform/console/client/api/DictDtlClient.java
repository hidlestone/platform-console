package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.DictDtlRequest;
import com.wordplay.platform.console.model.response.DictDtlResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/dictdtl")
public interface DictDtlClient {

	@RequestMapping("/getdictdtlsbydictcode")
	ResponseResult<List<DictDtlResponse>> getDictDtlsByDictCode(@RequestParam String dictCode);

	@PostMapping("/list")
	ResponseResult<Leaf<DictDtlResponse>> list(@RequestBody DictDtlRequest request);

}
