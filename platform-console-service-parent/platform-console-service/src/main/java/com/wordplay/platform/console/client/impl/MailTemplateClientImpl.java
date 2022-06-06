package com.wordplay.platform.console.client.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.mail.entity.MailTemplate;
import com.fallframework.platform.starter.mail.service.MailTemplateService;
import com.wordplay.platform.console.client.api.MailTemplateClient;
import com.wordplay.platform.console.model.request.MailTemplateRequest;
import com.wordplay.platform.console.model.response.MailTemplateResponse;
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
@Api(tags = "邮件模板")
@RestController
@RequestMapping("/${platform.console.service.version}/mailtemplate")
public class MailTemplateClientImpl implements MailTemplateClient {

	@Autowired
	private MailTemplateService mailTemplateService;

	@Override
	@PostMapping("/save")
	@ApiOperation("保存邮件发送配置")
	public ResponseResult save(@RequestBody MailTemplateRequest request) {
		MailTemplate mailTemplate = new MailTemplate();
		BeanUtils.copyProperties(request, mailTemplate);
		mailTemplateService.save(mailTemplate);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/delete")
	@ApiOperation("删除邮件发送配置")
	public ResponseResult delete(@RequestParam Long id) {
		mailTemplateService.removeById(id);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/update")
	@ApiOperation("修改邮件发送配置")
	public ResponseResult update(@RequestBody MailTemplateRequest request) {
		MailTemplate mailTemplate = new MailTemplate();
		BeanUtils.copyProperties(request, mailTemplate);
		mailTemplateService.updateById(mailTemplate);
		return ResponseResult.success();
	}

	@Override
	@GetMapping("/get")
	@ApiOperation("查询邮件发送配置")
	public ResponseResult<MailTemplateResponse> get(@RequestParam Long id) {
		MailTemplate mailTemplate = mailTemplateService.getById(id);
		MailTemplateResponse response = new MailTemplateResponse();
		BeanUtils.copyProperties(mailTemplate, response);
		return ResponseResult.success(response);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation("分页查询邮件发送配置")
	public ResponseResult<Leaf<MailTemplateResponse>> list(@RequestBody MailTemplateRequest req) {
		MailTemplate mailTemplate = new MailTemplate();
		BeanUtils.copyProperties(req, mailTemplate);
		Page<MailTemplate> page = mailTemplateService.list(mailTemplate).getData();
		Leaf leaf = LeafPageUtil.pageToLeaf(page, MailTemplateResponse.class);
		return ResponseResult.success(leaf);
	}

}
