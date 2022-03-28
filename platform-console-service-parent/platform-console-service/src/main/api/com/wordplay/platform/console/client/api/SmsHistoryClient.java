package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.SmsHistoryReq;
import com.wordplay.platform.console.model.response.SmsHistoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 短信历史
 *
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/smshistory")
public interface SmsHistoryClient {

	@PostMapping("/delete")
	ResponseResult delete(@RequestParam Long id);

	@GetMapping("/get")
	ResponseResult<SmsHistoryResponse> get(@RequestParam Long id);

	@PostMapping("/list")
	ResponseResult<Leaf<SmsHistoryResponse>> list(@RequestBody SmsHistoryReq req);

}
