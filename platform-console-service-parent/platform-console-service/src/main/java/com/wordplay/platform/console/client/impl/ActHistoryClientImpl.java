package com.wordplay.platform.console.client.impl;

import com.fallframework.platform.starter.activiti.model.HistoricActivityInstanceQueryDto;
import com.fallframework.platform.starter.activiti.model.HistoricActivityOutVo;
import com.fallframework.platform.starter.activiti.model.HistoricTaskInstanceQueryDto;
import com.fallframework.platform.starter.activiti.service.ActHistoryService;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.ActHistoryClient;
import com.wordplay.platform.console.model.request.HistoricActivityInstanceQueryRequest;
import com.wordplay.platform.console.model.request.HistoricTaskInstanceQueryReequest;
import com.wordplay.platform.console.model.response.HistoricActivityResponse;
import com.wordplay.platform.console.model.response.HistoricTaskInstanceResponse;
import com.wordplay.platform.console.util.LeafPageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.activiti.engine.history.HistoricTaskInstance;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author zhuangpf
 */
@Api(tags = "流程lishi")
@RestController
@RequestMapping("/${platform.console.service.version}/acthistory")
public class ActHistoryClientImpl implements ActHistoryClient {

	@Autowired
	private ActHistoryService actHistoryService;

	@Override
	@PostMapping("/gethistoricactivitylist")
	@ApiOperation("分页查询历史活动信息")
	public ResponseResult<Leaf<HistoricActivityResponse>> getHistoricActivityList(@RequestBody HistoricActivityInstanceQueryRequest request) {
		HistoricActivityInstanceQueryDto dto = new HistoricActivityInstanceQueryDto();
		BeanUtils.copyProperties(request, dto);
		Leaf<HistoricActivityOutVo> page = actHistoryService.getHistoricActivityList(dto).getData();
		Leaf leaf = LeafPageUtil.leafToType(page, HistoricActivityResponse.class);
		return ResponseResult.success(leaf);
	}

	@Override
	@PostMapping("/gethistorictaskinstancelist")
	@ApiOperation("分页查询历史任务列表")
	public ResponseResult<Leaf<HistoricTaskInstanceResponse>> getHistoricTaskInstanceList(@RequestBody HistoricTaskInstanceQueryReequest request) {
		HistoricTaskInstanceQueryDto dto = new HistoricTaskInstanceQueryDto();
		Leaf<HistoricTaskInstance> page = actHistoryService.getHistoricTaskInstanceList(dto).getData();
		Leaf leaf = LeafPageUtil.leafToType(page, HistoricTaskInstanceResponse.class);
		return ResponseResult.success(leaf);
	}

	@Override
	@GetMapping("/generateprocessdiagram")
	@ApiOperation("根据流程实例ID获取获取流程(跟踪)图(高亮显示)")
	public ResponseResult<String> generateProcessDiagram(@RequestParam String processInstanceId) throws IOException {
		return actHistoryService.generateProcessDiagram(processInstanceId);
	}

}
