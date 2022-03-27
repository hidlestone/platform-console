package com.wordplay.platform.console.client.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.mail.entity.MailTemplate;
import com.fallframework.platform.starter.mail.model.MailTemplateRequest;
import com.wordplay.platform.console.model.MailTemplateReq;
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
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/mailtemplate")
public interface MailTemplateClient {

	@PostMapping("/save")
	ResponseResult save(@RequestBody MailTemplateReq req);

	@PostMapping("/delete")
	ResponseResult delete(@RequestParam Long id);

	@PostMapping("/update")
	ResponseResult update(@RequestBody MailTemplateReq req);

	@GetMapping("/get")
	ResponseResult<MailTemplate> get(@RequestParam Long id);

	@PostMapping("/list")
	ResponseResult<Page<MailTemplate>> list(@RequestBody MailTemplateReq req);

}
