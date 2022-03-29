package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.MailSenderConfigClient;
import com.wordplay.platform.console.model.request.MailSenderConfigReq;
import com.wordplay.platform.console.model.response.MailSenderConfigResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/mailsender")
public class MailSenderControl {

	@Autowired
	private MailSenderConfigClient mailSenderConfigClient;

	@PostMapping("/save")
	@ApiOperation(value = "保存邮件发送配置")
	public ResponseResult save(@RequestBody MailSenderConfigReq req) {
		return mailSenderConfigClient.save(req);
	}

	@PostMapping("/delete")
	@ApiOperation(value = "删除邮件发送配置")
	public ResponseResult delete(@RequestParam Long id) {
		return mailSenderConfigClient.delete(id);
	}

	@PostMapping("/update")
	@ApiOperation(value = "修改邮件发送配置")
	public ResponseResult update(@RequestBody MailSenderConfigReq req) {
		return mailSenderConfigClient.update(req);
	}

	@ApiOperation(value = "查询邮件发送配置")
	public ResponseResult<MailSenderConfigResponse> get(@RequestParam Long id) {
		return mailSenderConfigClient.get(id);
	}

	@PostMapping("/list")
	@ApiOperation(value = "分页查询邮件发送配置")
	public ResponseResult<Leaf<MailSenderConfigResponse>> list(MailSenderConfigReq req) {
		return mailSenderConfigClient.list(req);
	}

}