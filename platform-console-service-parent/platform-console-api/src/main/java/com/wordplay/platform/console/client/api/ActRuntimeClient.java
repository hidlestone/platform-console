package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.StartProcessInstanceRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/actruntime")
public interface ActRuntimeClient {

	/**
	 * 启动流程实例
	 *
	 * @param request 请求参数
	 * @return 是否启动成功
	 */
	@PostMapping("/startprocessinstance")
	ResponseResult startProcessInstance(@RequestBody StartProcessInstanceRequest request);

	/**
	 * 查询流程实例是否已经结束
	 *
	 * @param processInstanceId 流程实例ID
	 * @return 是否已经结束
	 */
	@GetMapping("/isprocessfinished")
	Boolean isProcessFinished(@RequestParam String processInstanceId);

}
