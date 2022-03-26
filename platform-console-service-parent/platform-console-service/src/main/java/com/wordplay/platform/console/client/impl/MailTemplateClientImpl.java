package com.wordplay.platform.console.client.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.mail.entity.MailTemplate;
import com.fallframework.platform.starter.mail.model.MailTemplateRequest;
import com.fallframework.platform.starter.mail.service.MailTemplateService;
import com.wordplay.platform.console.client.api.MailTemplateClient;
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
@Api(tags = "邮件模板")
@RestController
@RequestMapping("/mailtemplate")
public class MailTemplateClientImpl implements MailTemplateClient {

	@Autowired
	private MailTemplateService mailTemplateService;

	@Override
	@PostMapping("/save")
	@ApiOperation(value = "保存邮件发送配置")
	public ResponseResult save(@RequestBody MailTemplateRequest request) {
		MailTemplate mailTemplate = new MailTemplate();
		BeanUtils.copyProperties(request, mailTemplate);
		mailTemplateService.save(mailTemplate);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/delete")
	@ApiOperation(value = "删除邮件发送配置")
	public ResponseResult delete(@RequestParam Long id) {
		mailTemplateService.removeById(id);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/update")
	@ApiOperation(value = "修改邮件发送配置")
	public ResponseResult update(@RequestBody MailTemplateRequest request) {
		MailTemplate mailTemplate = new MailTemplate();
		BeanUtils.copyProperties(request, mailTemplate);
		mailTemplateService.update(mailTemplate);
		return ResponseResult.success();
	}

	@Override
	@GetMapping("/get")
	@ApiOperation(value = "查询邮件发送配置")
	public ResponseResult<MailTemplate> get(@RequestParam Long id) {
		MailTemplate mailTemplate = mailTemplateService.getById(id);
		return ResponseResult.success(mailTemplate);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation(value = "分页查询邮件发送配置")
	public ResponseResult<Page<MailTemplate>> list(@RequestBody MailTemplateRequest request) {
		return mailTemplateService.list(request);
	}
	
}
