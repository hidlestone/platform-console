package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.SmsConfigReq;
import com.wordplay.platform.console.model.response.SmsConfigResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 短信配置
 *
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/smsconfig")
public interface SmsConfigClient {

	@PostMapping("/save")
	ResponseResult save(@RequestBody SmsConfigReq req);

	@PostMapping("/savebatch")
	ResponseResult saveBatch(@RequestBody List<SmsConfigReq> reqList);

	@PostMapping("/delete")
	ResponseResult delete(@RequestParam Long id);

	@PostMapping("/update")
	ResponseResult update(@RequestBody SmsConfigReq req);

	@GetMapping("/get")
	ResponseResult<SmsConfigResponse> get(@RequestParam Long id);

	@PostMapping("/list")
	ResponseResult<Leaf<SmsConfigResponse>> list(@RequestBody SmsConfigReq req);

}
