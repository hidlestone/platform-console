package com.wordplay.platform.console.client.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.i18n.entity.I18nResource;
import com.fallframework.platform.starter.i18n.model.I18nResourceRequest;
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
	ResponseResult save(@RequestBody I18nResourceRequest request);

	@PostMapping("/savebatch")
	ResponseResult saveBatch(@RequestBody List<I18nResourceRequest> i18nResourceRequestList);

	@PostMapping("/delete")
	ResponseResult delete(@RequestParam Long id);

	@PostMapping("/update")
	ResponseResult update(@RequestBody I18nResourceRequest request);

	@GetMapping("/get")
	ResponseResult<I18nResource> get(@RequestParam Long id);

	@GetMapping("/getbyresourcekey")
	ResponseResult<List<I18nResource>> getByResourceKey(@RequestParam String resourceKey);

	@PostMapping("/list")
	ResponseResult<Page<I18nResource>> list(@RequestBody I18nResourceRequest request);

}
