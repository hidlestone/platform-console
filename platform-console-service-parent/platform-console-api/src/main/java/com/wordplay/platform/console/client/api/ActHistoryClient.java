package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.HistoricActivityInstanceQueryRequest;
import com.wordplay.platform.console.model.request.HistoricTaskInstanceQueryReequest;
import com.wordplay.platform.console.model.response.HistoricActivityResponse;
import com.wordplay.platform.console.model.response.HistoricTaskInstanceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

/**
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/acthistory")
public interface ActHistoryClient {

	/**
	 * 根据流程实例ID分页查询历史活动信息
	 *
	 * @param request 请求参数
	 * @return 历史活动信息
	 */
	@PostMapping("/gethistoricactivitylist")
	ResponseResult<Leaf<HistoricActivityResponse>> getHistoricActivityList(@RequestBody HistoricActivityInstanceQueryRequest request);

	/**
	 * 分页查询历史任务列表
	 *
	 * @param request 请求参数
	 * @return 历史任务列表
	 */
	@PostMapping("/gethistorictaskinstancelist")
	ResponseResult<Leaf<HistoricTaskInstanceResponse>> getHistoricTaskInstanceList(@RequestBody HistoricTaskInstanceQueryReequest request);

	/**
	 * 根据流程实例ID获取获取流程(跟踪)图(高亮显示)
	 *
	 * @param processInstanceId 流程实例ID
	 * @return 流程图base64格式
	 */
	@GetMapping("/generateprocessdiagram")
	ResponseResult<String> generateProcessDiagram(@RequestParam String processInstanceId) throws IOException;

}
