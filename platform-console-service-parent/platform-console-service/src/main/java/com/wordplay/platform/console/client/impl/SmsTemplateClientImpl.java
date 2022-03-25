package com.wordplay.platform.console.client.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.sms.entity.SmsTemplate;
import com.fallframework.platform.starter.sms.model.SmsTemplateReqeust;
import com.wordplay.platform.console.client.api.SmsTemplateClient;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhuangpf
 */
@Api(tags = "短信模板")
@RestController
@RequestMapping("/smstemplate")
public class SmsTemplateClientImpl implements SmsTemplateClient {
	

	@Override
	public ResponseResult save(SmsTemplateReqeust request) {
		return null;
	}

	@Override
	public ResponseResult saveBatch(List<SmsTemplateReqeust> smsTemplateReqeustList) {
		return null;
	}

	@Override
	public ResponseResult delete(Long id) {
		return null;
	}

	@Override
	public ResponseResult update(SmsTemplateReqeust request) {
		return null;
	}

	@Override
	public ResponseResult<SmsTemplate> get(Long id) {
		return null;
	}

	@Override
	public ResponseResult<Page<SmsTemplate>> list(SmsTemplateReqeust request) {
		return null;
	}
}
