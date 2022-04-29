package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.SmsTemplateClient;
import com.wordplay.platform.console.model.request.SmsTemplateReq;
import com.wordplay.platform.console.model.response.SmsTemplateResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhuangpf
 */
@Api(tags = "短信模板")
@RestController
@RequestMapping("/${platform.console.control.version}/smstemplate")
public class SmsTemplateControl {

	@Autowired
	private SmsTemplateClient smsTemplateClient;

	@PostMapping("/save")
	@ApiOperation(value = "保存短信模板")
	public ResponseResult save(@RequestBody SmsTemplateReq req) {
		return smsTemplateClient.save(req);
	}

	@PostMapping("/savebatch")
	@ApiOperation(value = "批量保存短信模板")
	public ResponseResult saveBatch(@RequestBody List<SmsTemplateReq> reqList) {
		return smsTemplateClient.saveBatch(reqList);
	}

	@PostMapping("/delete")
	@ApiOperation(value = "删除短信模板")
	public ResponseResult delete(@RequestParam Long id) {
		return smsTemplateClient.delete(id);
	}

	@PostMapping("/update")
	@ApiOperation(value = "修改短信模板")
	public ResponseResult update(@RequestBody SmsTemplateReq req) {
		return smsTemplateClient.update(req);
	}

	@GetMapping("/get")
	@ApiOperation(value = "查询短信模板")
	public ResponseResult<SmsTemplateResponse> get(@RequestParam Long id) {
		return smsTemplateClient.get(id);
	}

	@PostMapping("/list")
	@ApiOperation(value = "分页查询短信模板")
	public ResponseResult<Leaf<SmsTemplateResponse>> list(@RequestBody SmsTemplateReq req) {
		return smsTemplateClient.list(req);
	}

}
