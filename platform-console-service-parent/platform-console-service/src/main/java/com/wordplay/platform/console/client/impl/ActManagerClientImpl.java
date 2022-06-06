package com.wordplay.platform.console.client.impl;

import com.wordplay.platform.console.client.api.ActManagerClient;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuangpf
 */
@Api(tags = "流程管理")
@RestController
@RequestMapping("/${platform.console.service.version}/actmanager")
public class ActManagerClientImpl implements ActManagerClient {
	
}
