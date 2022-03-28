package com.wordplay.platform.console.client.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.sms.entity.SmsHistory;
import com.fallframework.platform.starter.sms.model.SmsHistoryRequest;
import com.fallframework.platform.starter.sms.service.SmsHistoryService;
import com.wordplay.platform.console.client.api.SmsHistoryClient;
import com.wordplay.platform.console.model.request.SmsHistoryReq;
import com.wordplay.platform.console.model.response.SmsHistoryResponse;
import com.wordplay.platform.console.util.LeafPageUtil;
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
@Api(tags = "短信历史")
@RestController
@RequestMapping("/${platform.console.service.version}/smshistory")
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
	public ResponseResult<SmsHistoryResponse> get(@RequestParam Long id) {
		SmsHistory smsHistory = smsHistoryService.getById(id);
		SmsHistoryResponse response = new SmsHistoryResponse();
		BeanUtils.copyProperties(smsHistory, response);
		return ResponseResult.success(response);
	}

	@Override
	@GetMapping("/list")
	@ApiOperation(value = "分页查询短信历史")
	public ResponseResult<Leaf<SmsHistoryResponse>> list(@RequestBody SmsHistoryReq req) {
		SmsHistoryRequest request = new SmsHistoryRequest();
		Page<SmsHistory> page = smsHistoryService.list(request).getData();
		Leaf leaf = LeafPageUtil.pageToLeaf(page, SmsHistoryResponse.class);
		return ResponseResult.success(leaf);
	}

}
