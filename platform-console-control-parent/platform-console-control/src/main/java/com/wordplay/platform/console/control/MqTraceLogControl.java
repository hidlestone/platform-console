package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.MqTraceLogClient;
import com.wordplay.platform.console.model.request.MqTraceLogReq;
import com.wordplay.platform.console.model.response.MqTraceLogResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/${platform.console.control.version}/mqtracelog")
public class MqTraceLogControl {

	@Autowired
	private MqTraceLogClient mqTraceLogClient;

	@PostMapping("/delete")
	@ApiOperation(value = "删除MQ轨迹日志")
	public ResponseResult delete(@RequestParam Long id) {
		return mqTraceLogClient.delete(id);
	}

	@GetMapping("/get")
	@ApiOperation(value = "查询MQ轨迹日志")
	public ResponseResult<MqTraceLogResponse> get(@RequestParam Long id) {
		return mqTraceLogClient.get(id);
	}

	@PostMapping("/list")
	@ApiOperation(value = "分页查询MQ轨迹日志")
	public ResponseResult<Leaf<MqTraceLogResponse>> list(@RequestBody MqTraceLogReq req) {
		return mqTraceLogClient.list(req);
	}

}
