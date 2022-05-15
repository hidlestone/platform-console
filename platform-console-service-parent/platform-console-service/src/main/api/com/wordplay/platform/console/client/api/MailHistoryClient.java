package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.MailHistoryRequest;
import com.wordplay.platform.console.model.response.MailHistoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/mailhistory")
public interface MailHistoryClient {

	@PostMapping("/delete")
	ResponseResult delete(@RequestParam Long id);

	@GetMapping("/get")
	ResponseResult<MailHistoryResponse> get(@RequestParam Long id);

	@PostMapping("/list")
	ResponseResult<Leaf<MailHistoryResponse>> list(@RequestBody MailHistoryRequest request);

}
