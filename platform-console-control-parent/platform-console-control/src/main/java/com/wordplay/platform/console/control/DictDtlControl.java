package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.DictDtlClient;
import com.wordplay.platform.console.model.request.DictDtlRequest;
import com.wordplay.platform.console.model.response.DictDtlResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhuangpf
 */
@Api(tags = "数据字典")
@RestController
@RequestMapping("/${platform.console.control.version}/dictdtl")
public class DictDtlControl {

	@Autowired
	private DictDtlClient dictDtlClient;

	@RequestMapping("/getdictdtlsbydictcode")
	@ApiOperation(value = "根据字典编码查询明细")
	public ResponseResult<List<DictDtlResponse>> getDictDtlsByDictCode(String dictCode) {
		return dictDtlClient.getDictDtlsByDictCode(dictCode);
	}

	@RequestMapping("/list")
	@ApiOperation(value = "分页查询字典明细")
	public ResponseResult<Leaf<DictDtlResponse>> list(DictDtlRequest request) {
		return dictDtlClient.list(request);
	}
}
