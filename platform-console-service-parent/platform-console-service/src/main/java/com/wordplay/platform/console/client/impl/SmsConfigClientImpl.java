package com.wordplay.platform.console.client.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.sms.entity.SmsConfig;
import com.fallframework.platform.starter.sms.service.SmsConfigService;
import com.wordplay.platform.console.client.api.SmsConfigClient;
import com.wordplay.platform.console.model.request.SmsConfigRequest;
import com.wordplay.platform.console.model.response.SmsConfigResponse;
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

import java.util.Date;
import java.util.List;

/**
 * @author zhuangpf
 */
@Api(tags = "短信配置")
@RestController
@RequestMapping("/${platform.console.service.version}/smsconfig")
public class SmsConfigClientImpl implements SmsConfigClient {

	@Autowired
	private SmsConfigService smsConfigService;

	@Override
	@PostMapping("/save")
	@ApiOperation(value = "保存短信配置")
	public ResponseResult save(@RequestBody SmsConfigRequest req) {
		SmsConfig smsConfig = new SmsConfig();
		BeanUtils.copyProperties(req, smsConfig);
		smsConfigService.save(smsConfig);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/savebatch")
	@ApiOperation(value = "批量保存短信配置")
	public ResponseResult saveBatch(@RequestBody List<SmsConfigRequest> reqList) {
		List<SmsConfig> smsConfigList = JSON.parseArray(JSON.toJSONString(reqList), SmsConfig.class);
		smsConfigService.saveBatch(smsConfigList);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/delete")
	@ApiOperation(value = "删除短信配置")
	public ResponseResult delete(@RequestParam Long id) {
		smsConfigService.removeById(id);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/update")
	@ApiOperation(value = "修改短信配置")
	public ResponseResult update(@RequestBody SmsConfigRequest req) {
		SmsConfig smsConfig = new SmsConfig();
		BeanUtils.copyProperties(req, smsConfig);
		smsConfig.setGmtModified(new Date());
		smsConfigService.updateById(smsConfig);
		return ResponseResult.success();
	}

	@Override
	@GetMapping("/get")
	@ApiOperation(value = "查询短信配置")
	public ResponseResult<SmsConfigResponse> get(@RequestParam Long id) {
		SmsConfig smsConfig = smsConfigService.getById(id);
		SmsConfigResponse response = new SmsConfigResponse();
		BeanUtils.copyProperties(smsConfig, response);
		return ResponseResult.success(response);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation(value = "分页查询短信配置")
	public ResponseResult<Leaf<SmsConfigResponse>> list(@RequestBody SmsConfigRequest req) {
		SmsConfig smsConfig = new SmsConfig();
		BeanUtils.copyProperties(req, smsConfig);
		Page<SmsConfig> page = smsConfigService.list(smsConfig).getData();
		Leaf leaf = LeafPageUtil.pageToLeaf(page, SmsConfigResponse.class);
		return ResponseResult.success(leaf);
	}

}
