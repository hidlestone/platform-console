package com.wordplay.platform.console.client.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.sms.entity.SmsConfig;
import com.fallframework.platform.starter.sms.model.SmsConfigRequest;
import com.fallframework.platform.starter.sms.service.SmsConfigService;
import com.wordplay.platform.console.client.api.SmsConfigClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhuangpf
 */
@Api(tags = "短信配置")
@RestController
@RequestMapping("/smsconfig")
public class SmsConfigClientImpl implements SmsConfigClient {

	@Autowired
	private SmsConfigService smsConfigService;

	@Override
	@PostMapping("/save")
	@ApiOperation(value = "保存短信配置")
	public ResponseResult save(SmsConfigRequest request) {
		SmsConfig smsConfig = new SmsConfig();
		BeanUtils.copyProperties(request, smsConfig);
		smsConfigService.save(smsConfig);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/savebatch")
	@ApiOperation(value = "批量保存短信配置")
	public ResponseResult saveBatch(List<SmsConfigRequest> smsConfigRequestList) {
		List<SmsConfig> smsConfigList = JSON.parseArray(JSON.toJSONString(smsConfigRequestList), SmsConfig.class);
		smsConfigService.saveBatch(smsConfigList);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/delete")
	@ApiOperation(value = "删除短信配置")
	public ResponseResult delete(Long id) {
		smsConfigService.removeById(id);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/update")
	@ApiOperation(value = "修改短信配置")
	public ResponseResult update(SmsConfigRequest request) {
		SmsConfig smsConfig = new SmsConfig();
		BeanUtils.copyProperties(request, smsConfig);
		smsConfigService.updateById(smsConfig);
		return ResponseResult.success();
	}

	@Override
	@GetMapping("/get")
	@ApiOperation(value = "查询短信配置")
	public ResponseResult<SmsConfig> get(Long id) {
		SmsConfig smsConfig = smsConfigService.getById(id);
		return ResponseResult.success(smsConfig);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation(value = "分页查询短信配置")
	public ResponseResult<Page<SmsConfig>> list(SmsConfigRequest request) {
		return smsConfigService.list(request);
	}

}