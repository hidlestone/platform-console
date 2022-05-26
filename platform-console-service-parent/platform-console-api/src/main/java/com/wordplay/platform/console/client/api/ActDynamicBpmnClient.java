package com.wordplay.platform.console.client.api;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/actdynamicbpmn")
public interface ActDynamicBpmnClient {
}
