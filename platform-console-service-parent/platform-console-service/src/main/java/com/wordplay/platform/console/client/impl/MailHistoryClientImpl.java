package com.wordplay.platform.console.client.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.mail.entity.MailHistory;
import com.fallframework.platform.starter.mail.model.MailHistoryRequest;
import com.fallframework.platform.starter.mail.service.MailHistoryService;
import com.wordplay.platform.console.client.api.MailHistoryClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuangpf
 */
@Api(tags = "邮件历史")
@RestController
@RequestMapping("/mailtemplate")
public class MailHistoryClientImpl implements MailHistoryClient {

	@Autowired
	private MailHistoryService mailHistoryService;

	@Override
	@PostMapping("/delete")
	@ApiOperation(value = "删除邮件历史")
	public ResponseResult delete(Long id) {
		mailHistoryService.removeById(id);
		return ResponseResult.success();
	}

	@Override
	@GetMapping("/get")
	@ApiOperation(value = "查询邮件历史")
	public ResponseResult<MailHistory> get(Long id) {
		MailHistory mailHistory = mailHistoryService.getById(id);
		return ResponseResult.success(mailHistory);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation(value = "分页查询邮件历史")
	public ResponseResult<Page<MailHistory>> list(MailHistoryRequest request) {
		return mailHistoryService.list(request);
	}
	
}
