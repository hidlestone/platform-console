package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.MailTemplateClient;
import com.wordplay.platform.console.model.request.MailTemplateReq;
import com.wordplay.platform.console.model.response.MailTemplateResponse;
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
@Api(tags = "邮件模板")
@RestController
@RequestMapping("/${platform.console.control.version}/mailtemplate")
public class MailTemplateControl {

	@Autowired
	private MailTemplateClient mailTemplateClient;

	@PostMapping("/save")
	@ApiOperation(value = "保存邮件发送配置")
	public ResponseResult save(@RequestBody MailTemplateReq req) {
		return mailTemplateClient.save(req);
	}

	@PostMapping("/delete")
	@ApiOperation(value = "删除邮件发送配置")
	public ResponseResult delete(@RequestParam Long id) {
		return mailTemplateClient.delete(id);
	}

	@PostMapping("/update")
	@ApiOperation(value = "修改邮件发送配置")
	public ResponseResult update(@RequestBody MailTemplateReq req) {
		return mailTemplateClient.update(req);
	}

	@GetMapping("/get")
	@ApiOperation(value = "查询邮件发送配置")
	public ResponseResult<MailTemplateResponse> get(@RequestParam Long id) {
		return mailTemplateClient.get(id);
	}

	@PostMapping("/list")
	@ApiOperation(value = "分页查询邮件发送配置")
	public ResponseResult<Leaf<MailTemplateResponse>> list(@RequestBody MailTemplateReq req) {
		return mailTemplateClient.list(req);
	}

}
