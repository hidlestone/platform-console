package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.DictDtlClient;
import com.wordplay.platform.console.model.request.DictDtlRequest;
import com.wordplay.platform.console.model.response.DictDtlResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "数据字典")
@RestController
@RequestMapping("/${platform.console.control.version}/dictdtl")
public class DictDtlControl {

	@Autowired
	private DictDtlClient dictDtlClient;

	@PostMapping("/save")
	@ApiOperation("保存字典明细")
	public ResponseResult save(@RequestBody DictDtlRequest request) {
		return dictDtlClient.save(request);
	}

	@PostMapping("/delete")
	@ApiOperation("删除字典明细")
	public ResponseResult delete(@RequestParam Long id) {
		return dictDtlClient.delete(id);
	}

	@PostMapping("/update")
	@ApiOperation("更新字典明细")
	public ResponseResult update(@RequestBody DictDtlRequest request) {
		return dictDtlClient.update(request);
	}

	@GetMapping("/get")
	@ApiOperation("查询字典明细")
	public ResponseResult<DictDtlResponse> get(@RequestParam Long id) {
		return dictDtlClient.get(id);
	}

	@RequestMapping("/getdictdtlsbydictcode")
	@ApiOperation("根据字典编码查询明细")
	public ResponseResult<List<DictDtlResponse>> getDictDtlsByDictCode(@RequestParam String dictCode) {
		return dictDtlClient.getDictDtlsByDictCode(dictCode);
	}

	@RequestMapping("/list")
	@ApiOperation("分页查询字典明细")
	public ResponseResult<Leaf<DictDtlResponse>> list(@RequestBody DictDtlRequest request) {
		return dictDtlClient.list(request);
	}

}
