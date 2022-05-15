package com.wordplay.platform.console.client.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.config.entity.Dict;
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

/**
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/dict")
public class DictClientImpl implements DictClient {

	@Autowired
	private DictService dictService;

	@Override
	@PostMapping("/savedict")
	@ApiOperation(value = "保存字典项")
	public ResponseResult saveDict(DictRequest request) {
		Dict dict = JSON.parseObject(JSON.toJSONString(request), Dict.class);
		return dictService.saveDict(dict);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation(value = "分页查询字典项")
	public ResponseResult<Leaf<DictResponse>> list(DictRequest request) {
		Dict dict = new Dict();
		BeanUtils.copyProperties(request, dict);
		Page<Dict> page = dictService.list(dict).getData();
		Leaf leaf = LeafPageUtil.pageToLeaf(page, DictResponse.class);
		return ResponseResult.success(leaf);
	}

}
