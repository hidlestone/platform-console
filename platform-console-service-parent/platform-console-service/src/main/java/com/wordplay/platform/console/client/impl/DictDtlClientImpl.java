package com.wordplay.platform.console.client.impl;

import com.alibaba.fastjson.JSON;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.config.entity.DictDtl;
import com.fallframework.platform.starter.config.service.DictDtlService;
import com.wordplay.platform.console.client.api.DictDtlClient;
import com.wordplay.platform.console.model.request.DictDtlRequest;
import com.wordplay.platform.console.model.response.DictDtlResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/dictdtl")
public class DictDtlClientImpl implements DictDtlClient {

	@Autowired
	private DictDtlService dictDtlService;

	@Override
	@RequestMapping("/getDictDtlsByDictCode")
	@ApiOperation(value = "根据字典编码查询明细")
	public ResponseResult<List<DictDtlResponse>> getDictDtlsByDictCode(String dictCode) {
		List<DictDtl> dictDtlList = dictDtlService.getDictDtlsByDictCode(dictCode).getData();
		List<DictDtlResponse> dictDtlResponseList = JSON.parseArray(JSON.toJSONString(dictDtlList), DictDtlResponse.class);
		return ResponseResult.success(dictDtlResponseList);
	}

	@Override
	public ResponseResult<Leaf<DictDtlResponse>> list(DictDtlRequest request) {
		return null;
	}

}
