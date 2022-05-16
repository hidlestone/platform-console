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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseResult saveDict(DictRequest request) {
		return dictClient.saveDict(request);
	}

	@PostMapping("/list")
	@ApiOperation(value = "分页查询字典项")
	public ResponseResult<Leaf<DictResponse>> list(DictRequest request) {
		return dictClient.list(request);
	}

}
