package com.wordplay.platform.console.client.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.config.entity.Dict;
import com.fallframework.platform.starter.config.entity.DictDtl;
import com.fallframework.platform.starter.config.service.DictDtlService;
import com.fallframework.platform.starter.config.service.DictService;
import com.wordplay.platform.console.client.api.DictClient;
import com.wordplay.platform.console.model.request.DictRequest;
import com.wordplay.platform.console.model.response.DictResponse;
import com.wordplay.platform.console.util.LeafPageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/dict")
public class DictClientImpl implements DictClient {

	@Autowired
	private DictService dictService;
	@Autowired
	private DictDtlService dictDtlService;

	@Override
	@PostMapping("/savedict")
	@ApiOperation(value = "保存字典项")
	public ResponseResult saveDict(@RequestBody DictRequest request) {
		Dict dict = JSON.parseObject(JSON.toJSONString(request), Dict.class);
		return dictService.saveDict(dict);
	}

	@Override
	@PostMapping("/delete")
	@ApiOperation(value = "删除字典项")
	public ResponseResult delete(@RequestParam Long id) {
		Dict dict = dictService.getById(id);
		QueryWrapper<DictDtl> wrapper = new QueryWrapper<>();
		wrapper.eq("dict_id", dict.getId());
		dictDtlService.remove(wrapper);
		dictService.removeById(id);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/update")
	@ApiOperation(value = "删除字典项")
	public ResponseResult update(@RequestBody DictRequest request) {
		Dict dict = JSON.parseObject(JSON.toJSONString(request), Dict.class);
		dictService.updateById(dict);
		// 更新明细
		List<DictDtl> dictDtls = dict.getDictDtls();
		dictDtlService.updateBatchById(dictDtls);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/get")
	@ApiOperation(value = "查询字典项")
	public ResponseResult<DictResponse> get(@RequestParam Long id) {
		Dict dict = dictService.getById(id);
		QueryWrapper<DictDtl> wrapper = new QueryWrapper<>();
		wrapper.eq("dict_id", dict.getId());
		List<DictDtl> dictDtls = dictDtlService.list(wrapper);
		dict.setDictDtls(dictDtls);
		// 转换
		DictResponse response = JSON.parseObject(JSON.toJSONString(dict), DictResponse.class);
		return ResponseResult.success(response);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation(value = "分页查询字典项")
	public ResponseResult<Leaf<DictResponse>> list(@RequestBody DictRequest request) {
		Dict dict = new Dict();
		BeanUtils.copyProperties(request, dict);
		Page<Dict> page = dictService.list(dict).getData();
		Leaf leaf = LeafPageUtil.pageToLeaf(page, DictResponse.class);
		return ResponseResult.success(leaf);
	}

}
