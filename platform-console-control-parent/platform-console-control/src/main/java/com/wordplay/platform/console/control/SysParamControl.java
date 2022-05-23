package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.SysParamClient;
import com.wordplay.platform.console.model.request.SysParamItemRequest;
import com.wordplay.platform.console.model.response.SysParamItemResponse;
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
@Api(tags = "系统参数明细")
@RestController
@RequestMapping("/${platform.console.control.version}/sysparam")
public class SysParamControl {

	@Autowired
	private SysParamClient sysParamClient;

	@PostMapping("/save")
	@ApiOperation(value = "保存配置明细项")
	public ResponseResult save(@RequestBody SysParamItemRequest request) {
		return sysParamClient.save(request);
	}

	@PostMapping("/delete")
	@ApiOperation(value = "删除明细项")
	public ResponseResult delete(@RequestParam String code) {
		return sysParamClient.delete(code);
	}

	@PostMapping("/updateitem")
	@ApiOperation(value = "更新配置明细项")
	public ResponseResult updateItem(@RequestBody SysParamItemRequest request) {
		return sysParamClient.update(request);
	}

	@GetMapping("/getitemsbygroupcode")
	@ApiOperation(value = "根据配置组编码查询配置明细项")
	public ResponseResult<List<SysParamItemResponse>> getItemsByGroupCode(@RequestParam String groupCode) {
		return sysParamClient.getItemsByGroupCode(groupCode);
	}

	@GetMapping("/get")
	@ApiOperation(value = "根据编码查询配置明细")
	public ResponseResult<SysParamItemResponse> get(String code) {
		return sysParamClient.get(code);
	}

	@PostMapping("/list")
	@ApiOperation(value = "分页查询配置明细")
	public ResponseResult<Leaf<SysParamItemResponse>> list(SysParamItemRequest request) {
		return sysParamClient.list(request);
	}

}
