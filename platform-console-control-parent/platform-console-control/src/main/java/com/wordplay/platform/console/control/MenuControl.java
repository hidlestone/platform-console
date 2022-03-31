package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.MenuClient;
import com.wordplay.platform.console.model.request.MenuQueryReq;
import com.wordplay.platform.console.model.request.MenuReq;
import com.wordplay.platform.console.model.response.MenuResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuangpf
 */
@Api(tags = "菜单管理")
@RestController
@RequestMapping("/${platform.console.control.version}/menu")
public class MenuControl {

	@Autowired
	private MenuClient menuClient;

	@PostMapping("/save")
	@ApiOperation(value = "保存菜单")
	public ResponseResult save(@RequestBody MenuReq req) {
		return menuClient.save(req);
	}

	@PostMapping("/delete")
	@ApiOperation(value = "删除菜单")
	public ResponseResult delete(@RequestParam Long id) {
		return menuClient.delete(id);
	}

	@PostMapping("/update")
	@ApiOperation(value = "修改菜单")
	public ResponseResult update(@RequestBody MenuReq req) {
		return menuClient.update(req);
	}

	@GetMapping("/get")
	@ApiOperation(value = "查询菜单")
	public ResponseResult<MenuResponse> get(@RequestParam Long id) {
		return menuClient.get(id);
	}

	@PostMapping("/list")
	@ApiOperation(value = "分页查询菜单")
	public ResponseResult<Leaf<MenuResponse>> list(@RequestBody MenuReq req) {
		return menuClient.list(req);
	}

	@PostMapping("/getmenusbyuserid")
	@ApiOperation(value = "根据用户ID查询菜单")
	public ResponseResult<Leaf<MenuResponse>> getMenusByUserId(@RequestBody MenuQueryReq req) {
		return menuClient.getMenusByUserId(req);
	}

	@PostMapping("/getmenusbyroleids")
	@ApiOperation(value = "根据角色ID查询菜单")
	public ResponseResult<Leaf<MenuResponse>> getMenusByRoleIds(@RequestBody MenuQueryReq req) {
		return menuClient.getMenusByRoleIds(req);
	}

}
