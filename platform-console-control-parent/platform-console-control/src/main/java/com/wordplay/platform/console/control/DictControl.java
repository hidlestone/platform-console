package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.DictClient;
import com.wordplay.platform.console.model.request.DictRequest;
import com.wordplay.platform.console.model.response.DictResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/${platform.console.control.version}/dict")
public class DictControl {

	@Autowired
	private DictClient dictClient;

	@PostMapping("/savedict")
	@ApiOperation(value = "保存字典项")
	public ResponseResult saveDict(@RequestBody DictRequest request) {
		return dictClient.saveDict(request);
	}

	@PostMapping("/delete")
	@ApiOperation(value = "删除字典项")
	public ResponseResult delete(@RequestParam Long id) {
		return dictClient.delete(id);
	}

	@PostMapping("/update")
	@ApiOperation(value = "删除字典项")
	public ResponseResult update(@RequestBody DictRequest request) {
		return dictClient.update(request);
	}

	@PostMapping("/get")
	@ApiOperation(value = "查询字典项")
	public ResponseResult<DictResponse> get(@RequestParam Long id) {
		return dictClient.get(id);
	}

	@PostMapping("/list")
	@ApiOperation(value = "分页查询字典项")
	public ResponseResult<Leaf<DictResponse>> list(@RequestBody DictRequest request) {
		return dictClient.list(request);
	}

	@PostMapping("/getalldicts")
	@ApiOperation(value = "查询所有字典项")
	public ResponseResult<List<DictResponse>> getAllDicts() {
		return dictClient.getAllDicts();
	}

}
