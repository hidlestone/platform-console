package com.wordplay.platform.console.client.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.sms.entity.SmsTemplate;
import com.fallframework.platform.starter.sms.model.SmsTemplateReqeust;
import com.fallframework.platform.starter.sms.service.SmsTemplateService;
import com.wordplay.platform.console.client.api.SmsTemplateClient;
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

import java.util.List;

/**
 * @author zhuangpf
 */
@Api(tags = "短信模板")
@RestController
@RequestMapping("/smstemplate")
public class SmsTemplateClientImpl implements SmsTemplateClient {

	@Autowired
	private SmsTemplateService smsTemplateService;

	@Override
	@PostMapping("/save")
	@ApiOperation(value = "保存短信模板")
	public ResponseResult save(@RequestBody SmsTemplateReqeust request) {
		SmsTemplate smsTemplate = new SmsTemplate();
		BeanUtils.copyProperties(request, smsTemplate);
		smsTemplateService.save(smsTemplate);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/savebatch")
	@ApiOperation(value = "批量保存短信模板")
	public ResponseResult saveBatch(@RequestBody List<SmsTemplateReqeust> smsTemplateReqeustList) {
		List<SmsTemplate> smsTemplateList = JSON.parseArray(JSON.toJSONString(smsTemplateReqeustList), SmsTemplate.class);
		smsTemplateService.saveBatch(smsTemplateList);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/delete")
	@ApiOperation(value = "删除短信模板")
	public ResponseResult delete(@RequestParam Long id) {
		smsTemplateService.removeById(id);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/update")
	@ApiOperation(value = "修改短信模板")
	public ResponseResult update(@RequestBody SmsTemplateReqeust request) {
		SmsTemplate smsTemplate = new SmsTemplate();
		BeanUtils.copyProperties(request, smsTemplate);
		smsTemplateService.updateById(smsTemplate);
		return ResponseResult.success();
	}

	@Override
	@GetMapping("/get")
	@ApiOperation(value = "查询短信模板")
	public ResponseResult<SmsTemplate> get(@RequestParam Long id) {
		SmsTemplate smsTemplate = smsTemplateService.getById(id);
		return ResponseResult.success(smsTemplate);
	}

	@Override
	@GetMapping("/list")
	@ApiOperation(value = "分页查询短信模板")
	public ResponseResult<Page<SmsTemplate>> list(@RequestBody SmsTemplateReqeust request) {
		return smsTemplateService.list(request);
	}
	
}
