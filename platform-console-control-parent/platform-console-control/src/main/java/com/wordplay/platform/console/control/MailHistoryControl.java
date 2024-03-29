package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.MailHistoryClient;
import com.wordplay.platform.console.model.request.MailHistoryRequest;
import com.wordplay.platform.console.model.response.MailHistoryResponse;
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
@Api(tags = "邮件历史")
@RestController
@RequestMapping("/${platform.console.control.version}/mailhistory")
public class MailHistoryControl {

	@Autowired
	private MailHistoryClient mailHistoryClient;

	@PostMapping("/delete")
	@ApiOperation("删除邮件历史")
	public ResponseResult delete(@RequestParam Long id) {
		return mailHistoryClient.delete(id);
	}

	@GetMapping("/get")
	@ApiOperation("查询邮件历史")
	public ResponseResult<MailHistoryResponse> get(@RequestParam Long id) {
		return mailHistoryClient.get(id);
	}

	@PostMapping("/list")
	@ApiOperation("分页查询邮件历史")
	public ResponseResult<Leaf<MailHistoryResponse>> list(@RequestBody MailHistoryRequest request) {
		return mailHistoryClient.list(request);
	}

}
