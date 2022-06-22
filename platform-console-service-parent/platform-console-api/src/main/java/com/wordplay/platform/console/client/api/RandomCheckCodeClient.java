package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 登录页随机校验码
 *
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/randomcheckcode")
public interface RandomCheckCodeClient {

	@GetMapping("/getrandomcheckcode")
	ResponseResult getRandomCheckCode();

}
