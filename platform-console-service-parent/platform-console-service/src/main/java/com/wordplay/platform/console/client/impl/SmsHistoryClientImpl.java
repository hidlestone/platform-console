package com.wordplay.platform.console.client.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.sms.entity.SmsHistory;
import com.fallframework.platform.starter.sms.model.SmsHistoryRequest;
import com.fallframework.platform.starter.sms.service.SmsHistoryService;
import com.wordplay.platform.console.client.api.SmsHistoryClient;
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
@RequestMapping("/smshistory")
public class SmsHistoryClientImpl implements SmsHistoryClient {

	@Autowired
	private SmsHistoryService smsHistoryService;

	@Override
	@PostMapping("/delete")
	@ApiOperation(value = "删除短信历史")
	public ResponseResult delete(@RequestParam Long id) {
		smsHistoryService.removeById(id);
		return ResponseResult.success();
	}

	@Override
	@GetMapping("/get")
	@ApiOperation(value = "查询短信历史")
	public ResponseResult<SmsHistory> get(@RequestParam Long id) {
		smsHistoryService.getById(id);
		return ResponseResult.success();
	}

	@Override
	@GetMapping("/list")
	@ApiOperation(value = "分页查询短信历史")
	public ResponseResult<Page<SmsHistory>> list(@RequestBody SmsHistoryRequest request) {
		smsHistoryService.list(request);
		return ResponseResult.success();
	}
	
}
