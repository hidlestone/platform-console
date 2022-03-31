package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.SysParamClient;
import com.wordplay.platform.console.model.request.SysParamGroupReq;
import com.wordplay.platform.console.model.request.SysParamItemReq;
import com.wordplay.platform.console.model.response.SysParamGroupResp;
import com.wordplay.platform.console.model.response.SysParamItemResp;
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
@Api(tags = "系统参数")
@RestController
@RequestMapping("/${platform.console.control.version}/smstemplate")
public class SysParamControl {

	@Autowired
	private SysParamClient sysParamClient;

	@PostMapping("/savegroup")
	@ApiOperation(value = "保存配置组及明细项")
	public ResponseResult saveGroup(@RequestBody SysParamGroupReq req) {
		return sysParamClient.saveGroup(req);
	}

	@PostMapping("/saveitem")
	@ApiOperation(value = "保存配置明细项")
	public ResponseResult saveItem(@RequestBody SysParamItemReq req) {
		return sysParamClient.saveItem(req);
	}

	@PostMapping("/deletegroup")
	@ApiOperation(value = "删除配置组及明细项")
	public ResponseResult deleteGroup(@RequestParam String code) {
		return sysParamClient.deleteGroup(code);
	}

	@PostMapping("/deleteitem")
	@ApiOperation(value = "删除明细项")
	public ResponseResult deleteItem(@RequestParam String code) {
		return sysParamClient.deleteItem(code);
	}

	@PostMapping("/updategroup")
	@ApiOperation(value = "更新配置组及明细项")
	public ResponseResult updateGroup(@RequestBody SysParamGroupReq req) {
		return sysParamClient.updateGroup(req);
	}

	@PostMapping("/updateitem")
	@ApiOperation(value = "更新配置明细项")
	public ResponseResult updateItem(@RequestBody SysParamItemReq req) {
		return sysParamClient.updateItem(req);
	}

	@GetMapping("/getgroupitems")
	@ApiOperation(value = "根据配置组编码查询配置组及明细项")
	public ResponseResult<SysParamGroupResp> getGroupItems(@RequestParam String code) {
		return sysParamClient.getGroupItems(code);
	}

	@GetMapping("/getitemsbygroupcode")
	@ApiOperation(value = "根据配置组编码查询配置明细项")
	public ResponseResult<List<SysParamItemResp>> getItemsByGroupCode(@RequestParam String groupCode) {
		return sysParamClient.getItemsByGroupCode(groupCode);
	}

	@GetMapping("/groupList")
	@ApiOperation(value = "分页查询配置组及明细项")
	public ResponseResult<Leaf<SysParamGroupResp>> groupList(@RequestBody SysParamGroupReq req) {
		return sysParamClient.groupList(req);
	}

}
