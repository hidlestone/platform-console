package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.WxWorkSynConfigClient;
import com.wordplay.platform.console.model.request.WxWorkSynConfigRequest;
import com.wordplay.platform.console.model.response.WxWorkSynConfigResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuangpf
 */
@Api(tags = "企微-通讯录-同步配置")
@RestController
@RequestMapping("/${platform.console.control.version}/wxworksynconfig")
public class WxWorkSynConfigControl {

	@Autowired
	private WxWorkSynConfigClient wxWorkSynConfigClient;

	@GetMapping("/get")
	@ApiOperation("查询同步配置")
	public ResponseResult<WxWorkSynConfigResponse> get(@RequestParam Long id) {
		return wxWorkSynConfigClient.get(id);
	}

	@PostMapping("/list")
	@ApiOperation("分页查询同步配置")
	public ResponseResult<Leaf<WxWorkSynConfigResponse>> list(@RequestBody WxWorkSynConfigRequest request) {
		return wxWorkSynConfigClient.list(request);
	}

}
