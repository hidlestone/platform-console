package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.MailSenderConfigReq;
import com.wordplay.platform.console.model.response.MailSenderConfigResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 邮件发送配置
 *
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/mailsenderconfig")
public interface MailSenderConfigClient {

	@PostMapping("/save")
	ResponseResult save(@RequestBody MailSenderConfigReq req);

	@PostMapping("/delete")
	ResponseResult delete(@RequestParam Long id);

	@PostMapping("/update")
	ResponseResult update(@RequestBody MailSenderConfigReq req);

	@GetMapping("/get")
	ResponseResult<MailSenderConfigResponse> get(@RequestParam Long id);

	@PostMapping("/list")
	ResponseResult<Leaf<MailSenderConfigResponse>> list(@RequestBody MailSenderConfigReq req);

}
