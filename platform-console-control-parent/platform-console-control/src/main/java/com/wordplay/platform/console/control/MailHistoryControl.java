package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.MailHistoryClient;
import com.wordplay.platform.console.model.request.MailHistoryReq;
import com.wordplay.platform.console.model.response.MailHistoryResponse;
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
@RequestMapping("/mailhistory")
public class MailHistoryControl {

	@Autowired
	private MailHistoryClient mailHistoryClient;

	@PostMapping("/delete")
	@ApiOperation(value = "删除邮件历史")
	public ResponseResult delete(Long id) {
		return mailHistoryClient.delete(id);
	}

	@GetMapping("/get")
	@ApiOperation(value = "查询邮件历史")
	public ResponseResult<MailHistoryResponse> get(Long id) {
		return mailHistoryClient.get(id);
	}

	@PostMapping("/list")
	@ApiOperation(value = "分页查询邮件历史")
	public ResponseResult<Leaf<MailHistoryResponse>> list(MailHistoryReq req) {
		return mailHistoryClient.list(req);
	}

}
