package com.wordplay.platform.console.client.api;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户登录
 *
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/login")
public interface LoginClient {
}
