package com.wordplay.platform.console.client.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.config.entity.Dict;
import com.fallframework.platform.starter.config.entity.DictDtl;
import com.fallframework.platform.starter.config.service.DictDtlService;
import com.fallframework.platform.starter.config.service.DictService;
import com.wordplay.platform.console.client.api.DictDtlClient;
import com.wordplay.platform.console.model.request.DictDtlRequest;
import com.wordplay.platform.console.model.response.DictDtlResponse;
import com.wordplay.platform.console.util.LeafPageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/dictdtl")
public class DictDtlClientImpl implements DictDtlClient {

	@Autowired
	private DictDtlService dictDtlService;
	@Autowired
	private DictService dictService;

	@Override
	@PostMapping("/save")
	public ResponseResult save(@RequestBody DictDtlRequest request) {
		Dict dict = dictService.getById(request.getDictId());
		if (null == dict) {
			return ResponseResult.fail("字典项不存在");
		}
		DictDtl dictDtl = JSON.parseObject(JSON.toJSONString(request), DictDtl.class);
		dictDtlService.save(dictDtl);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/delete")
	public ResponseResult delete(@RequestParam Long id) {
		dictService.removeById(id);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/update")
	public ResponseResult update(@RequestBody DictDtlRequest request) {
		Dict dict = dictService.getById(request.getDictId());
		if (null == dict) {
			return ResponseResult.fail("字典项不存在");
		}
		DictDtl dictDtl = JSON.parseObject(JSON.toJSONString(request), DictDtl.class);
		dictDtlService.updateById(dictDtl);
		return ResponseResult.success();
	}

	@Override
	@GetMapping("/get")
	public ResponseResult<DictDtlResponse> get(@RequestParam Long id) {
		DictDtl dictDtl = dictDtlService.getById(id);
		DictDtlResponse response = new DictDtlResponse();
		BeanUtils.copyProperties(dictDtl, response);
		return ResponseResult.success(response);
	}

	@Override
	@RequestMapping("/getdictdtlsbydictcode")
	@ApiOperation(value = "根据字典编码查询明细")
	public ResponseResult<List<DictDtlResponse>> getDictDtlsByDictCode(@RequestParam String dictCode) {
		List<DictDtl> dictDtlList = dictDtlService.getDictDtlsByDictCode(dictCode).getData();
		List<DictDtlResponse> dictDtlResponseList = JSON.parseArray(JSON.toJSONString(dictDtlList), DictDtlResponse.class);
		return ResponseResult.success(dictDtlResponseList);
	}

	@Override
	@RequestMapping("/list")
	@ApiOperation(value = "分页查询字典明细")
	public ResponseResult<Leaf<DictDtlResponse>> list(@RequestBody DictDtlRequest request) {
		DictDtl dictDtl = new DictDtl();
		BeanUtils.copyProperties(request, dictDtl);
		Page<DictDtl> page = dictDtlService.list(dictDtl).getData();
		Leaf leaf = LeafPageUtil.pageToLeaf(page, DictDtlResponse.class);
		return ResponseResult.success(leaf);
	}

}
