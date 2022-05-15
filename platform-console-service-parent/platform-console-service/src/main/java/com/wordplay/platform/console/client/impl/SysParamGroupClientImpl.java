package com.wordplay.platform.console.client.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.config.entity.SysParamGroup;
import com.fallframework.platform.starter.config.service.SysParamGroupService;
import com.wordplay.platform.console.client.api.SysParamGroupClient;
import com.wordplay.platform.console.model.request.SysParamGroupQueryRequest;
import com.wordplay.platform.console.model.response.SysParamGroupResponse;
import com.wordplay.platform.console.util.LeafPageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuangpf
 */
@Api(tags = "系统参数组")
@RestController
@RequestMapping("/${platform.console.service.version}/sysparamgroup")
public class SysParamGroupClientImpl implements SysParamGroupClient {

	@Autowired
	private SysParamGroupService sysParamGroupService;

	@Override
	@ApiOperation(value = "根据配置组编码查询配置组及明细项")
	public ResponseResult<SysParamGroupResponse> get(@RequestParam String code) {
		SysParamGroup sysParamGroup = sysParamGroupService.get(code).getData();
		SysParamGroupResponse response = JSON.parseObject(JSON.toJSONString(sysParamGroup), SysParamGroupResponse.class);
		return ResponseResult.success(response);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation(value = "分页查询配置组")
	public ResponseResult<Leaf<SysParamGroupResponse>> list(@RequestBody SysParamGroupQueryRequest request) {
		SysParamGroup sysParamGroup = new SysParamGroup();
		BeanUtils.copyProperties(request, sysParamGroup);
		Page<SysParamGroup> page = sysParamGroupService.list(sysParamGroup).getData();
		Leaf leaf = LeafPageUtil.pageToLeaf(page, SysParamGroupResponse.class);
		return ResponseResult.success(leaf);
	}
	
}
