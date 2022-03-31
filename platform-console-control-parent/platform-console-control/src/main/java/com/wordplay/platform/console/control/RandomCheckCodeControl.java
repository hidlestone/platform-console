package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.RandomCheckCodeClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuangpf
 */
@Api(tags = "随机校验码")
@RestController
@RequestMapping("/${platform.console.control.version}/verifycode")
public class RandomCheckCodeControl {

	@Autowired
	private RandomCheckCodeClient randomCheckCodeClient;

	@PostMapping("/getrandomcheckcode")
	@ApiOperation(value = "四位随机校验码")
	public ResponseResult getRandomCheckCode() {
		return randomCheckCodeClient.getRandomCheckCode();
	}

}
