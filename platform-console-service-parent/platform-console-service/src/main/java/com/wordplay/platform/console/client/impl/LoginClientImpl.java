package com.wordplay.platform.console.client.impl;

import com.wordplay.platform.console.client.api.LoginClient;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuangpf
 */
@Api(tags = "用户登录")
@RestController
@RequestMapping("/${platform.console.service.version}/login")
public class LoginClientImpl implements LoginClient {
}
