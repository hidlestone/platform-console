package com.wordplay.platform.console.client.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.sms.entity.SmsTemplate;
import com.fallframework.platform.starter.sms.service.SmsTemplateService;
import com.wordplay.platform.console.client.api.SmsTemplateClient;
import com.wordplay.platform.console.model.request.SmsTemplateRequest;
import com.wordplay.platform.console.model.response.SmsTemplateResponse;
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

import java.util.List;

/**
 * @author zhuangpf
 */
@Api(tags = "短信模板")
@RestController
@RequestMapping("/${platform.console.service.version}/smstemplate")
public class SmsTemplateClientImpl implements SmsTemplateClient {

	@Autowired
	private SmsTemplateService smsTemplateService;

	@Override
	@PostMapping("/save")
	@ApiOperation("保存短信模板")
	public ResponseResult save(@RequestBody SmsTemplateRequest request) {
		SmsTemplate smsTemplate = new SmsTemplate();
		BeanUtils.copyProperties(request, smsTemplate);
		smsTemplateService.save(smsTemplate);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/savebatch")
	@ApiOperation("批量保存短信模板")
	public ResponseResult saveBatch(@RequestBody List<SmsTemplateRequest> reqList) {
		List<SmsTemplate> smsTemplateList = JSON.parseArray(JSON.toJSONString(reqList), SmsTemplate.class);
		smsTemplateService.saveBatch(smsTemplateList);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/delete")
	@ApiOperation("删除短信模板")
	public ResponseResult delete(@RequestParam Long id) {
		smsTemplateService.removeById(id);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/update")
	@ApiOperation("修改短信模板")
	public ResponseResult update(@RequestBody SmsTemplateRequest request) {
		SmsTemplate smsTemplate = new SmsTemplate();
		BeanUtils.copyProperties(request, smsTemplate);
		smsTemplateService.updateById(smsTemplate);
		return ResponseResult.success();
	}

	@Override
	@GetMapping("/get")
	@ApiOperation("查询短信模板")
	public ResponseResult<SmsTemplateResponse> get(@RequestParam Long id) {
		SmsTemplate smsTemplate = smsTemplateService.getById(id);
		SmsTemplateResponse response = new SmsTemplateResponse();
		BeanUtils.copyProperties(smsTemplate, response);
		return ResponseResult.success(response);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation("分页查询短信模板")
	public ResponseResult<Leaf<SmsTemplateResponse>> list(@RequestBody SmsTemplateRequest request) {
		SmsTemplate smsTemplate = new SmsTemplate();
		BeanUtils.copyProperties(request, smsTemplate);
		Page<SmsTemplate> page = smsTemplateService.list(smsTemplate).getData();
		Leaf leaf = LeafPageUtil.pageToLeaf(page, SmsTemplateResponse.class);
		return ResponseResult.success(leaf);
	}

}
