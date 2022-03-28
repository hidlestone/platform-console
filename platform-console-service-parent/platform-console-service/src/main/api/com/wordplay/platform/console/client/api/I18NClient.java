package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.I18nResourceReq;
import com.wordplay.platform.console.model.response.I18nResourceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 使用feign暴露外部接口。路径使用全小写。
 *
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/i18n")
public interface I18NClient {

	@PostMapping("/save")
	ResponseResult save(@RequestBody I18nResourceReq req);

	@PostMapping("/savebatch")
	ResponseResult saveBatch(@RequestBody List<I18nResourceReq> reqList);

	@PostMapping("/delete")
	ResponseResult delete(@RequestParam Long id);

	@PostMapping("/update")
	ResponseResult update(@RequestBody I18nResourceReq req);

	@GetMapping("/get")
	ResponseResult<I18nResourceResponse> get(@RequestParam Long id);

	@GetMapping("/getbyresourcekey")
	ResponseResult<List<I18nResourceResponse>> getByResourceKey(@RequestParam String resourceKey);

	@PostMapping("/list")
	ResponseResult<Leaf<I18nResourceResponse>> list(@RequestBody I18nResourceReq req);

}
