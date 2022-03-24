package com.wordplay.platform.console.client.impl;

import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.i18n.model.I18nResourceRequest;
import com.wordplay.platform.console.client.api.I18NClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuangpf
 */
@Api(tags = "I18N")
@RestController
public class I18NClientImpl implements I18NClient {

	@Override
	@PostMapping("/save")
	@ApiOperation(value = "新建提交")
	public ResponseResult save(I18nResourceRequest request) {
		return null;
	}

}
