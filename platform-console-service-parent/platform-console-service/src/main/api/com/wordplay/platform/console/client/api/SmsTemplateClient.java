package com.wordplay.platform.console.client.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.sms.entity.SmsTemplate;
import com.fallframework.platform.starter.sms.model.SmsTemplateReqeust;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 短信模板
 *
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/smstemplate")
public interface SmsTemplateClient {

	@PostMapping("/save")
	ResponseResult save(@RequestBody SmsTemplateReqeust request);

	@PostMapping("/savebatch")
	ResponseResult saveBatch(@RequestBody List<SmsTemplateReqeust> smsTemplateReqeustList);

	@PostMapping("/delete")
	ResponseResult delete(@RequestParam Long id);

	@PostMapping("/update")
	ResponseResult update(@RequestBody SmsTemplateReqeust request);

	@GetMapping("/get")
	ResponseResult<SmsTemplate> get(@RequestParam Long id);

	@PostMapping("/list")
	ResponseResult<Page<SmsTemplate>> list(@RequestBody SmsTemplateReqeust request);

}
