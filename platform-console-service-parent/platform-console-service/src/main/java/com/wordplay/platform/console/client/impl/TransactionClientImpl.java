package com.wordplay.platform.console.client.impl;

import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.TransactionClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuangpf
 */
@Api(tags = "交易查询服务")
@RestController
@RequestMapping("/${platform.console.service.version}/transaction")
public class TransactionClientImpl implements TransactionClient {

	@Override
	@PostMapping("/list")
	@ApiOperation("分页查询交易")
	public ResponseResult list() {
		return null;
	}

}
