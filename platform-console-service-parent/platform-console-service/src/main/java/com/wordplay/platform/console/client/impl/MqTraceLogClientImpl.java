package com.wordplay.platform.console.client.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.data.mp.util.LeafPageUtil;
import com.fallframework.platform.starter.mq.entity.MqTraceLog;
import com.fallframework.platform.starter.mq.service.MqTraceLogService;
import com.wordplay.platform.console.client.api.MqTraceLogClient;
import com.wordplay.platform.console.model.request.MqTraceLogRequest;
import com.wordplay.platform.console.model.response.MqTraceLogResponse;
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
@Api(tags = "MQ轨迹日志")
@RestController
@RequestMapping("/${platform.console.service.version}/mqtracelog")
public class MqTraceLogClientImpl implements MqTraceLogClient {

	@Autowired
	private MqTraceLogService mqTraceLogService;

	@Override
	@PostMapping("/delete")
	@ApiOperation("删除MQ轨迹日志")
	public ResponseResult delete(@RequestParam Long id) {
		mqTraceLogService.removeById(id);
		return ResponseResult.success();
	}

	@Override
	@GetMapping("/get")
	@ApiOperation("查询MQ轨迹日志")
	public ResponseResult<MqTraceLogResponse> get(@RequestParam Long id) {
		MqTraceLog mqTraceLog = mqTraceLogService.getById(id);
		MqTraceLogResponse response = new MqTraceLogResponse();
		BeanUtils.copyProperties(mqTraceLog, response);
		return ResponseResult.success(response);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation("分页查询MQ轨迹日志")
	public ResponseResult<Leaf<MqTraceLogResponse>> list(@RequestBody MqTraceLogRequest req) {
		MqTraceLog mqTraceLog = new MqTraceLog();
		BeanUtils.copyProperties(req, mqTraceLog);
		Page<MqTraceLog> page = mqTraceLogService.list(mqTraceLog).getData();
		Leaf leaf = LeafPageUtil.pageToLeaf(page, MqTraceLogResponse.class);
		return ResponseResult.success(leaf);
	}

}
