package com.wordplay.platform.console.client.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.config.entity.SysParamItem;
import com.fallframework.platform.starter.config.service.SysParamGroupService;
import com.fallframework.platform.starter.config.service.SysParamItemService;
import com.fallframework.platform.starter.data.mp.util.LeafPageUtil;
import com.wordplay.platform.console.client.api.SysParamClient;
import com.wordplay.platform.console.model.request.SysParamItemRequest;
import com.wordplay.platform.console.model.response.SysParamItemResponse;
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

import java.util.List;

/**
 * @author zhuangpf
 */
@Api(tags = "系统参数")
@RestController
@RequestMapping("/${platform.console.service.version}/sysparam")
public class SysParamClientImpl implements SysParamClient {

	@Autowired
	private SysParamGroupService sysParamGroupService;
	@Autowired
	private SysParamItemService sysParamItemService;

	@Override
	@PostMapping("/save")
	@ApiOperation("保存配置明细项")
	public ResponseResult save(@RequestBody SysParamItemRequest request) {
		SysParamItem sysParamItem = new SysParamItem();
		BeanUtils.copyProperties(request, sysParamItem);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/delete")
	@ApiOperation("删除明细项")
	public ResponseResult delete(@RequestParam String code) {
		QueryWrapper<SysParamItem> wrapper = new QueryWrapper();
		wrapper.eq("code", code);
		sysParamItemService.remove(wrapper);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/update")
	@ApiOperation("更新配置明细项")
	public ResponseResult update(@RequestBody SysParamItemRequest request) {
		SysParamItem sysParamItem = new SysParamItem();
		BeanUtils.copyProperties(request, sysParamItem);
		sysParamItemService.updateById(sysParamItem);
		return ResponseResult.success();
	}

	@Override
	@GetMapping("/getitemsbygroupcode")
	@ApiOperation("根据配置组编码查询配置明细项")
	public ResponseResult<List<SysParamItemResponse>> getItemsByGroupCode(@RequestParam String groupCode) {
		QueryWrapper<SysParamItem> wrapper = new QueryWrapper();
		wrapper.eq("group_code", groupCode);
		List<SysParamItem> list = sysParamItemService.list(wrapper);
		List<SysParamItemResponse> respList = JSON.parseArray(JSON.toJSONString(list), SysParamItemResponse.class);
		return ResponseResult.success(respList);
	}

	@Override
	@GetMapping("/get")
	@ApiOperation("根据编码查询配置明细")
	public ResponseResult<SysParamItemResponse> get(@RequestParam String code) {
		SysParamItem sysParamItem = sysParamItemService.get(code).getData();
		SysParamItemResponse response = new SysParamItemResponse();
		BeanUtils.copyProperties(sysParamItem, response);
		return ResponseResult.success(response);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation("分页查询配置明细")
	public ResponseResult<Leaf<SysParamItemResponse>> list(@RequestBody SysParamItemRequest request) {
		SysParamItem sysParamItem = new SysParamItem();
		BeanUtils.copyProperties(request, sysParamItem);
		Page<SysParamItem> page = sysParamItemService.list(sysParamItem).getData();
		Leaf leaf = LeafPageUtil.pageToLeaf(page, SysParamItemResponse.class);
		return ResponseResult.success(leaf);
	}

}
