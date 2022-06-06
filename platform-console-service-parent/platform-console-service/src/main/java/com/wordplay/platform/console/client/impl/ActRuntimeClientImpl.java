package com.wordplay.platform.console.client.impl;

import com.fallframework.platform.starter.activiti.model.StartProcessInstanceDto;
import com.fallframework.platform.starter.activiti.service.ActRuntimeService;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.ActRuntimeClient;
import com.wordplay.platform.console.model.request.StartProcessInstanceRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuangpf
 */
@Api(tags = "流程运行时")
@RestController
@RequestMapping("/${platform.console.service.version}/acttask")
public class ActRuntimeClientImpl implements ActRuntimeClient {

	@Autowired
	private ActRuntimeService actRuntimeService;

	@Override
	@PostMapping("/startprocessinstance")
	@ApiOperation("启动流程实例")
	public ResponseResult startProcessInstance(@RequestBody StartProcessInstanceRequest request) {
		StartProcessInstanceDto dto = new StartProcessInstanceDto();
		BeanUtils.copyProperties(request, dto);
		return actRuntimeService.startProcessInstance(dto);
	}

	@Override
	@GetMapping("/isprocessfinished")
	@ApiOperation("查询流程实例是否已经结束")
	public Boolean isProcessFinished(@RequestParam String processInstanceId) {
		return actRuntimeService.isProcessFinished(processInstanceId);
	}
	
}
