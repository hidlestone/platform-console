package com.wordplay.platform.console.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.service.RandomCheckCodeService;

/**
 * @author zhuangpf
 */
public class RandomCheckCodeServiceImpl implements RandomCheckCodeService {

	@Override
	public ResponseResult getRandomCheckCode() {
		String randomCheckCode = RandomUtil.randomString(4);
		return ResponseResult.success(randomCheckCode);
	}

}
