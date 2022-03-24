package com.wordplay.platform.console.client.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.i18n.entity.I18nResource;
import com.fallframework.platform.starter.i18n.model.I18nResourceRequest;
import com.fallframework.platform.starter.i18n.service.I18nResourceService;
import com.wordplay.platform.console.client.api.I18NClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhuangpf
 */
@Api(tags = "I18N") // 该client接口说明，即接口文档中的标题列。
@RestController
public class I18NClientImpl implements I18NClient {

	@Autowired
	private I18nResourceService i18nResourceService;

	@Override
	@PostMapping("/save")
	@ApiOperation(value = "新增I8N词条")
	public ResponseResult save(I18nResourceRequest request) {
		I18nResource i18nResource = new I18nResource();
		BeanUtils.copyProperties(request, i18nResource);
		i18nResourceService.save(i18nResource);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/savebatch")
	@ApiOperation(value = "批量新增I8N词条")
	public ResponseResult saveBatch(List<I18nResourceRequest> i18nResourceRequestList) {
		List<I18nResource> i18nResourceList = JSON.parseArray(JSON.toJSONString(i18nResourceRequestList), I18nResource.class);
		for (I18nResource entity : i18nResourceList) {
			i18nResourceService.save(entity);
		}
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/delete")
	@ApiOperation(value = "删除I8N词条")
	public ResponseResult delete(Long id) {
		i18nResourceService.removeById(id);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/update")
	@ApiOperation(value = "修改I8N词条")
	public ResponseResult update(I18nResourceRequest request) {
		I18nResource i18nResource = new I18nResource();
		i18nResourceService.updateById(i18nResource);
		return ResponseResult.success();
	}

	@Override
	@GetMapping("/get")
	@ApiOperation(value = "ID查询I8N词条")
	public ResponseResult<I18nResource> get(@RequestParam Long id) {
		I18nResource i18nResource = i18nResourceService.getById(id);
		return ResponseResult.success(i18nResource);
	}

	@Override
	@GetMapping("/selectbyresourcekey")
	@ApiOperation(value = "resourceKey查询I8N词条")
	public ResponseResult<List<I18nResource>> selectByResourceKey(@RequestParam String resourceKey) {
		return i18nResourceService.selectByResourceKey(resourceKey);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation(value = "分页查询I8N词条")
	public ResponseResult<Page<I18nResource>> list(I18nResourceRequest request) {
		return i18nResourceService.list(request);
	}

}
