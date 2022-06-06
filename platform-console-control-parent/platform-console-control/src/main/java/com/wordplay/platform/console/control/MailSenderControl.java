package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.MailSenderConfigClient;
import com.wordplay.platform.console.model.request.MailSenderConfigRequest;
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
@RequestMapping("/${platform.console.control.version}/mailsender")
public class MailSenderControl {

	@Autowired
	private MailSenderConfigClient mailSenderConfigClient;

	@PostMapping("/save")
	@ApiOperation("保存邮件发送配置")
	public ResponseResult save(@RequestBody MailSenderConfigRequest request) {
		return mailSenderConfigClient.save(request);
	}

	@PostMapping("/delete")
	@ApiOperation("删除邮件发送配置")
	public ResponseResult delete(@RequestParam Long id) {
		return mailSenderConfigClient.delete(id);
	}

	@PostMapping("/update")
	@ApiOperation("修改邮件发送配置")
	public ResponseResult update(@RequestBody MailSenderConfigRequest request) {
		return mailSenderConfigClient.update(request);
	}

	@ApiOperation("查询邮件发送配置")
	public ResponseResult<MailSenderConfigResponse> get(@RequestParam Long id) {
		return mailSenderConfigClient.get(id);
	}

	@PostMapping("/list")
	@ApiOperation("分页查询邮件发送配置")
	public ResponseResult<Leaf<MailSenderConfigResponse>> list(@RequestBody MailSenderConfigRequest request) {
		return mailSenderConfigClient.list(request);
	}

}
