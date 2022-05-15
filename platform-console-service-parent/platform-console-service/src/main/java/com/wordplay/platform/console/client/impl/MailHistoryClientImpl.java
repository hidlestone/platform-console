package com.wordplay.platform.console.client.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.mail.entity.MailHistory;
import com.fallframework.platform.starter.mail.service.MailHistoryService;
import com.wordplay.platform.console.client.api.MailHistoryClient;
import com.wordplay.platform.console.model.request.MailHistoryRequest;
import com.wordplay.platform.console.model.response.MailHistoryResponse;
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
@Api(tags = "邮件历史")
@RestController
@RequestMapping("/${platform.console.service.version}/mailhistory")
public class MailHistoryClientImpl implements MailHistoryClient {

	@Autowired
	private MailHistoryService mailHistoryService;

	@Override
	@PostMapping("/delete")
	@ApiOperation(value = "删除邮件历史")
	public ResponseResult delete(@RequestParam Long id) {
		mailHistoryService.removeById(id);
		return ResponseResult.success();
	}

	@Override
	@GetMapping("/get")
	@ApiOperation(value = "查询邮件历史")
	public ResponseResult<MailHistoryResponse> get(@RequestParam Long id) {
		MailHistory mailHistory = mailHistoryService.getById(id);
		MailHistoryResponse response = new MailHistoryResponse();
		BeanUtils.copyProperties(mailHistory, response);
		return ResponseResult.success(response);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation(value = "分页查询邮件历史")
	public ResponseResult<Leaf<MailHistoryResponse>> list(@RequestBody MailHistoryRequest req) {
		MailHistory mailHistory = new MailHistory();
		BeanUtils.copyProperties(req, mailHistory);
		Page<MailHistory> page = mailHistoryService.list(mailHistory).getData();
		Leaf leaf = LeafPageUtil.pageToLeaf(page, MailHistoryResponse.class);
		return ResponseResult.success(leaf);
	}

}
