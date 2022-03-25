package com.wordplay.platform.console.client.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.sms.entity.SmsConfig;
import com.fallframework.platform.starter.sms.model.SmsConfigRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 短信配置
 *
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/smsconfig")
public interface SmsConfigClient {

	@PostMapping("/save")
	ResponseResult save(@RequestBody SmsConfigRequest request);

	@PostMapping("/savebatch")
	ResponseResult saveBatch(@RequestBody List<SmsConfigRequest> smsConfigRequestList);

	@PostMapping("/delete")
	ResponseResult delete(@RequestParam Long id);

	@PostMapping("/update")
	ResponseResult update(@RequestBody SmsConfigRequest request);

	@GetMapping("/get")
	ResponseResult<SmsConfig> get(@RequestParam Long id);

	@PostMapping("/list")
	ResponseResult<Page<SmsConfig>> list(@RequestBody SmsConfigRequest request);

}
