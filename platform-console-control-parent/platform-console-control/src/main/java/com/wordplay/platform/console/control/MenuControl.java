package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.MenuClient;
import com.wordplay.platform.console.model.request.MenuQueryRequest;
import com.wordplay.platform.console.model.request.MenuRequest;
import com.wordplay.platform.console.model.response.FrontMenuResponse;
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

import java.util.List;

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
	public ResponseResult save(@RequestBody MenuRequest request) {
		return menuClient.save(request);
	}

	@PostMapping("/delete")
	@ApiOperation(value = "删除菜单")
	public ResponseResult delete(@RequestParam Long id) {
		return menuClient.delete(id);
	}

	@PostMapping("/update")
	@ApiOperation(value = "修改菜单")
	public ResponseResult update(@RequestBody MenuRequest request) {
		return menuClient.update(request);
	}

	@GetMapping("/get")
	@ApiOperation(value = "查询菜单")
	public ResponseResult<MenuResponse> get(@RequestParam Long id) {
		return menuClient.get(id);
	}

	@PostMapping("/list")
	@ApiOperation(value = "分页查询菜单")
	public ResponseResult<Leaf<MenuResponse>> list(@RequestBody MenuRequest request) {
		return menuClient.list(request);
	}

	@PostMapping("/getmenusbyuserid")
	@ApiOperation(value = "根据用户ID分页查询菜单")
	public ResponseResult<Leaf<MenuResponse>> getMenusByUserId(@RequestBody MenuQueryRequest request) {
		return menuClient.getMenusByUserId(request);
	}

	@PostMapping("/getmenusbyroleids")
	@ApiOperation(value = "根据角色ID分页查询菜单")
	public ResponseResult<Leaf<MenuResponse>> getMenusByRoleIds(@RequestBody MenuQueryRequest request) {
		return menuClient.getMenusByRoleIds(request);
	}

	@GetMapping("/getallmenus")
	@ApiOperation(value = "根据token获取当前用户所有菜单")
	public ResponseResult<List<FrontMenuResponse>> getAllMenus() {
		return menuClient.getAllMenus();
	}

	@PostMapping("/getmenutree")
	@ApiOperation(value = "查询菜单树")
	public ResponseResult<List<MenuResponse>> getMenuTree(@RequestBody MenuQueryRequest request) {
		return menuClient.getMenuTree(request);
	}

	@GetMapping("/getmenulistbyparentid")
	@ApiOperation(value = "根据父ID查询菜单")
	public ResponseResult<List<MenuResponse>> getMenuListByParentId(@RequestParam Long parentId) {
		return menuClient.getMenuListByParentId(parentId);
	}

	@GetMapping("/getmainmenus")
	@ApiOperation(value = "查询主菜单")
	public ResponseResult<List<MenuResponse>> getMainMenus() {
		return menuClient.getMainMenus();
	}

}
