package com.wordplay.platform.console.client.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.data.mp.util.LeafPageUtil;
import com.fallframework.platform.starter.wechatwork.entity.SynConfig;
import com.fallframework.platform.starter.wechatwork.service.SynConfigService;
import com.wordplay.platform.console.client.api.WxWorkSynConfigClient;
import com.wordplay.platform.console.model.request.WxWorkSynConfigRequest;
import com.wordplay.platform.console.model.response.WxWorkSynConfigResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
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
@RequestMapping("/${platform.console.service.version}/wxworksynconfig")
public class WxWorkSynConfigClientImpl implements WxWorkSynConfigClient {

	@Autowired
	private SynConfigService synConfigService;

	@Override
	@GetMapping("/get")
	@ApiOperation("查询同步配置") 
	public ResponseResult<WxWorkSynConfigResponse> get(@RequestParam Long id) {
		SynConfig synConfig = synConfigService.getById(id);
		WxWorkSynConfigResponse response = new WxWorkSynConfigResponse();
		BeanUtils.copyProperties(synConfig, response);
		return ResponseResult.success(response);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation("分页查询同步配置")
	public ResponseResult<Leaf<WxWorkSynConfigResponse>> list(@RequestBody WxWorkSynConfigRequest request) {
		SynConfig synConfig = new SynConfig();
		BeanUtils.copyProperties(request, synConfig);
		Page<SynConfig> page = synConfigService.list(synConfig).getData();
		Leaf leaf = LeafPageUtil.pageToLeaf(page, WxWorkSynConfigResponse.class);
		return ResponseResult.success(leaf);
	}
	
}
