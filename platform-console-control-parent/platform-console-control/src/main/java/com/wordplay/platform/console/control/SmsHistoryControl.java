package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.SmsHistoryClient;
import com.wordplay.platform.console.model.request.SmsHistoryRequest;
import com.wordplay.platform.console.model.response.SmsHistoryResponse;
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
@Api(tags = "短信历史")
@RestController
@RequestMapping("/${platform.console.control.version}/smshistory")
public class SmsHistoryControl {

	@Autowired
	private SmsHistoryClient smsHistoryClient;

	@PostMapping("/delete")
	@ApiOperation(value = "删除短信历史")
	public ResponseResult delete(@RequestParam Long id) {
		return smsHistoryClient.delete(id);
	}

	@GetMapping("/get")
	@ApiOperation(value = "查询短信历史")
	public ResponseResult<SmsHistoryResponse> get(@RequestParam Long id) {
		return smsHistoryClient.get(id);
	}

	@PostMapping("/list")
	@ApiOperation(value = "分页查询短信历史")
	public ResponseResult<Leaf<SmsHistoryResponse>> list(@RequestBody SmsHistoryRequest request) {
		return smsHistoryClient.list(request);
	}

}
