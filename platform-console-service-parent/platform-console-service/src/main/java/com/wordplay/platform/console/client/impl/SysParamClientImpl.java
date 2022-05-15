package com.wordplay.platform.console.client.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.config.entity.SysParamGroup;
import com.fallframework.platform.starter.config.entity.SysParamItem;
import com.fallframework.platform.starter.config.model.SysParamGroupResponse;
import com.fallframework.platform.starter.config.service.SysParamGroupService;
import com.fallframework.platform.starter.config.service.SysParamItemService;
import com.wordplay.platform.console.client.api.SysParamClient;
import com.wordplay.platform.console.model.request.SysParamGroupRequest;
import com.wordplay.platform.console.model.request.SysParamItemRequest;
import com.wordplay.platform.console.model.response.SysParamGroupResp;
import com.wordplay.platform.console.model.response.SysParamItemResp;
import com.wordplay.platform.console.util.LeafPageUtil;
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
	@PostMapping("/savegroup")
	@ApiOperation(value = "保存配置组及明细项")
	public ResponseResult saveGroup(@RequestBody SysParamGroupRequest request) {
		// 配置组
		SysParamGroup sysParamGroup = new SysParamGroup();
		BeanUtils.copyProperties(request, sysParamGroup);
		sysParamGroupService.save(sysParamGroup);
		// 明细项
		List<SysParamItem> sysParamItemList = JSON.parseArray(JSON.toJSONString(request.getSysParamItemList()), SysParamItem.class);
		sysParamItemService.saveBatch(sysParamItemList);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/saveitem")
	@ApiOperation(value = "保存配置明细项")
	public ResponseResult saveItem(@RequestBody SysParamItemRequest request) {
		SysParamItem sysParamItem = new SysParamItem();
		BeanUtils.copyProperties(request, sysParamItem);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/deletegroup")
	@ApiOperation(value = "删除配置组及明细项")
	public ResponseResult deleteGroup(@RequestParam String code) {
		// 配置组
		sysParamGroupService.removeById(code);
		// 明细项
		sysParamItemService.deleteByGroupCode(code);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/deleteitem")
	@ApiOperation(value = "删除明细项")
	public ResponseResult deleteItem(@RequestParam String code) {
		sysParamItemService.removeById(code);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/updategroup")
	@ApiOperation(value = "更新配置组及明细项")
	public ResponseResult updateGroup(@RequestBody SysParamGroupRequest request) {
		// 配置组
		SysParamGroup sysParamGroup = new SysParamGroup();
		BeanUtils.copyProperties(request, sysParamGroup);
		sysParamGroupService.updateById(sysParamGroup);
		// 明细项
		List<SysParamItem> sysParamItemList = JSON.parseArray(JSON.toJSONString(request.getSysParamItemList()), SysParamItem.class);
		sysParamItemService.updateBatchById(sysParamItemList);
		return ResponseResult.success();
	}

	@Override  
	@PostMapping("/updateitem")
	@ApiOperation(value = "更新配置明细项")
	public ResponseResult updateItem(@RequestBody SysParamItemRequest request) {
		SysParamItem sysParamItem = new SysParamItem();
		BeanUtils.copyProperties(request, sysParamItem);
		sysParamItemService.updateById(sysParamItem);
		return ResponseResult.success();
	}

	@Override
	@GetMapping("/getgroupitems")
	@ApiOperation(value = "根据配置组编码查询配置组及明细项")
	public ResponseResult<SysParamGroupResp> getGroupItems(@RequestParam String code) {
		ResponseResult<SysParamGroupResponse> list = sysParamGroupService.get(code);
		SysParamGroupResp resp = JSON.parseObject(JSON.toJSONString(list), SysParamGroupResp.class);
		return ResponseResult.success(resp);
	}

	@Override
	@GetMapping("/getitemsbygroupcode")
	@ApiOperation(value = "根据配置组编码查询配置明细项")
	public ResponseResult<List<SysParamItemResp>> getItemsByGroupCode(@RequestParam String groupCode) {
		List<SysParamItem> list = sysParamItemService.getByGroupCode(groupCode).getData();
		List<SysParamItemResp> respList = JSON.parseArray(JSON.toJSONString(list), SysParamItemResp.class);
		return ResponseResult.success(respList);
	}

	@Override
	@GetMapping("/groupList")
	@ApiOperation(value = "分页查询配置组及明细项")
	public ResponseResult<Leaf<SysParamGroupResp>> groupList(@RequestBody SysParamGroupRequest req) {
		com.fallframework.platform.starter.config.model.SysParamGroupRequest request = new com.fallframework.platform.starter.config.model.SysParamGroupRequest();
		BeanUtils.copyProperties(req, request);
		Page<SysParamGroupResponse> page = sysParamGroupService.list(request).getData();
		Leaf leaf = LeafPageUtil.pageToLeaf(page, SysParamGroupResp.class);
		return ResponseResult.success(leaf);
	}

}
