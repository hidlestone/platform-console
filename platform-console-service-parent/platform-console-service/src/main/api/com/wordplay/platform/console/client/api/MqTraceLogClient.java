package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.MqTraceLogReq;
import com.wordplay.platform.console.model.response.MqTraceLogResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/mqtracelog")
public interface MqTraceLogClient {

	@PostMapping("/delete")
	ResponseResult delete(@RequestParam Long id);

	@GetMapping("/get")
	ResponseResult<MqTraceLogResponse> get(@RequestParam Long id);

	@PostMapping("/list")
	ResponseResult<Leaf<MqTraceLogResponse>> list(MqTraceLogReq req);

}
