package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.SmsTemplateReq;
import com.wordplay.platform.console.model.response.SmsTemplateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 短信模板
 *
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/smstemplate")
public interface SmsTemplateClient {

	@PostMapping("/save")
	ResponseResult save(@RequestBody SmsTemplateReq req);

	@PostMapping("/savebatch")
	ResponseResult saveBatch(@RequestBody List<SmsTemplateReq> reqList);

	@PostMapping("/delete")
	ResponseResult delete(@RequestParam Long id);

	@PostMapping("/update")
	ResponseResult update(@RequestBody SmsTemplateReq req);

	@GetMapping("/get")
	ResponseResult<SmsTemplateResponse> get(@RequestParam Long id);

	@PostMapping("/list")
	ResponseResult<Leaf<SmsTemplateResponse>> list(@RequestBody SmsTemplateReq req);

}
