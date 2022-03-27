package com.wordplay.platform.console.client.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.mail.entity.MailSenderConfig;
import com.fallframework.platform.starter.mail.model.MailSenderConfigRequest;
import com.fallframework.platform.starter.mail.service.MailSenderConfigService;
import com.wordplay.platform.console.client.api.MailSenderConfigClient;
import com.wordplay.platform.console.model.MailSenderConfigReq;
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
@Api(tags = "邮件发送配置")
@RestController
@RequestMapping("/${platform.console.service.version}/mailsenderconfig")
public class MailSenderConfigClientImpl implements MailSenderConfigClient {

	@Autowired
	private MailSenderConfigService mailSenderConfigService;

	@Override
	@PostMapping("/save")
	@ApiOperation(value = "保存邮件发送配置")
	public ResponseResult save(@RequestBody MailSenderConfigReq req) {
		MailSenderConfig mailSenderConfig = new MailSenderConfig();
		BeanUtils.copyProperties(req, mailSenderConfig);
		mailSenderConfigService.save(mailSenderConfig);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/delete")
	@ApiOperation(value = "删除邮件发送配置")
	public ResponseResult delete(@RequestParam Long id) {
		mailSenderConfigService.removeById(id);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/update")
	@ApiOperation(value = "修改邮件发送配置")
	public ResponseResult update(@RequestBody MailSenderConfigReq req) {
		MailSenderConfig mailSenderConfig = new MailSenderConfig();
		BeanUtils.copyProperties(req, mailSenderConfig);
		mailSenderConfigService.updateById(mailSenderConfig);
		return ResponseResult.success();
	}

	@Override
	@GetMapping("/get")
	@ApiOperation(value = "查询邮件发送配置")
	public ResponseResult<MailSenderConfig> get(@RequestParam Long id) {
		MailSenderConfig mailSenderConfig = mailSenderConfigService.getById(id);
		return ResponseResult.success(mailSenderConfig);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation(value = "分页查询邮件发送配置")
	public ResponseResult<Page<MailSenderConfig>> list(MailSenderConfigReq req) {
		MailSenderConfigRequest request = new MailSenderConfigRequest();
		BeanUtils.copyProperties(req, request);
		return mailSenderConfigService.list(request);
	}

}
