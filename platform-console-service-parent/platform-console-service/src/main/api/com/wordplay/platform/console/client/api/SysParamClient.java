package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.SysParamGroupReq;
import com.wordplay.platform.console.model.request.SysParamItemReq;
import com.wordplay.platform.console.model.response.SysParamGroupResp;
import com.wordplay.platform.console.model.response.SysParamItemResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 系统参数
 *
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/sysparam")
public interface SysParamClient {

	@PostMapping("/savegroup")
	ResponseResult saveGroup(@RequestBody SysParamGroupReq req);

	@PostMapping("/saveitem")
	ResponseResult saveItem(@RequestBody SysParamItemReq req);

	@PostMapping("/deletegroup")
	ResponseResult deleteGroup(@RequestParam String code);

	@PostMapping("/deleteitem")
	ResponseResult deleteItem(@RequestParam String code);

	@PostMapping("/updategroup")
	ResponseResult updateGroup(@RequestBody SysParamGroupReq req);

	@PostMapping("/updateitem")
	ResponseResult updateItem(@RequestBody SysParamItemReq req);

	@GetMapping("/getgroupitems")
	ResponseResult<SysParamGroupResp> getGroupItems(@RequestParam String code);

	@GetMapping("/getitemsbygroupcode")
	ResponseResult<List<SysParamItemResp>> getItemsByGroupCode(@RequestParam String groupCode);

	@GetMapping("/groupList")
	ResponseResult<Leaf<SysParamGroupResp>> groupList(@RequestBody SysParamGroupReq req);

}
