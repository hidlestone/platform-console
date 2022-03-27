package com.wordplay.platform.console.client.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.mq.entity.MqTraceLog;
import com.fallframework.platform.starter.mq.model.MqTraceLogRequest;
import com.fallframework.platform.starter.mq.service.MqTraceLogService;
import com.wordplay.platform.console.client.api.MqTraceLogClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuangpf
 */
@Api(tags = "MQ轨迹日志")
@RestController
@RequestMapping("/${platform.console.service.version}/mqtracelog")
public class MqTraceLogClientImpl implements MqTraceLogClient {

	@Autowired
	private MqTraceLogService mqTraceLogService;

	@Override
	@PostMapping("/delete")
	@ApiOperation(value = "删除MQ轨迹日志")
	public ResponseResult delete(@RequestParam Long id) {
		mqTraceLogService.removeById(id);
		return ResponseResult.success();
	}

	@Override
	@GetMapping("/get")
	@ApiOperation(value = "查询MQ轨迹日志")
	public ResponseResult<MqTraceLog> get(Long id) {
		MqTraceLog mqTraceLog = mqTraceLogService.getById(id);
		return ResponseResult.success(mqTraceLog);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation(value = "分页查询MQ轨迹日志")
	public ResponseResult<Page<MqTraceLog>> list(MqTraceLogRequest request) {
		return mqTraceLogService.list(request);
	}
}
