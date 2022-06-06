package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.SmsConfigClient;
import com.wordplay.platform.console.model.request.SmsConfigRequest;
import com.wordplay.platform.console.model.response.SmsConfigResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhuangpf
 */
@Api(tags = "短信配置")
@RestController
@RequestMapping("/${platform.console.control.version}/smsconfig")
public class SmsConfigControl {

	@Resource
	private SmsConfigClient smsConfigClient;

	@PostMapping("/save")
	@ApiOperation("保存短信配置")
	public ResponseResult save(@RequestBody SmsConfigRequest request) {
		return smsConfigClient.save(request);
	}

	@PostMapping("/savebatch")
	@ApiOperation("批量保存短信配置")
	public ResponseResult saveBatch(@RequestBody List<SmsConfigRequest> reqList) {
		return smsConfigClient.saveBatch(reqList);
	}

	@PostMapping("/delete")
	@ApiOperation("删除短信配置")
	public ResponseResult delete(@RequestParam Long id) {
		return smsConfigClient.delete(id);
	}

	@PostMapping("/update")
	@ApiOperation("修改短信配置")
	public ResponseResult update(@RequestBody SmsConfigRequest request) {
		return smsConfigClient.update(request);
	}

	@GetMapping("/get")
	@ApiOperation("查询短信配置")
	public ResponseResult<SmsConfigResponse> get(@RequestParam Long id) {
		return smsConfigClient.get(id);
	}

	@PostMapping("/list")
	@ApiOperation("分页查询短信配置")
	public ResponseResult<Leaf<SmsConfigResponse>> list(@RequestBody SmsConfigRequest request) {
		return smsConfigClient.list(request);
	}

}
