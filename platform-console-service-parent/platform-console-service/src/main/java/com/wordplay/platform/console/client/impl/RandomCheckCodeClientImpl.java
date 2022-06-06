package com.wordplay.platform.console.client.impl;

import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.RandomCheckCodeClient;
import com.wordplay.platform.console.service.RandomCheckCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuangpf
 */
@Api(tags = "随机校验码")
@RestController
@RequestMapping("/${platform.console.service.version}/randomcheckcode")
public class RandomCheckCodeClientImpl implements RandomCheckCodeClient {

	@Autowired
	private RandomCheckCodeService randomCheckCodeService;

	@Override
	@GetMapping("/getrandomcheckcode")
	@ApiOperation("四位随机校验码")
	public ResponseResult getRandomCheckCode() {
		return randomCheckCodeService.getRandomCheckCode();
	}

}
