package com.wordplay.platform.console.client.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.rbac.entity.Menu;
import com.fallframework.platform.starter.rbac.model.MenuQueryRequest;
import com.fallframework.platform.starter.rbac.model.MenuRequest;
import com.fallframework.platform.starter.rbac.service.MenuService;
import com.wordplay.platform.console.client.api.MenuClient;
import com.wordplay.platform.console.model.request.MenuQueryReq;
import com.wordplay.platform.console.model.request.MenuReq;
import com.wordplay.platform.console.model.response.MenuResponse;
import com.wordplay.platform.console.util.LeafPageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
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
@RequestMapping("/${platform.console.service.version}/menu")
public class MenuClientImpl implements MenuClient {

	@Autowired
	private MenuService menuService;

	@Override
	@PostMapping("/save")
	@ApiOperation(value = "保存菜单")
	public ResponseResult save(@RequestBody MenuReq req) {
		Menu menu = new Menu();
		BeanUtils.copyProperties(req, menu);
		menuService.save(menu);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/delete")
	@ApiOperation(value = "删除菜单")
	public ResponseResult delete(@RequestParam Long id) {
		menuService.removeById(id);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/update")
	@ApiOperation(value = "修改菜单")
	public ResponseResult update(@RequestBody MenuReq req) {
		Menu menu = new Menu();
		BeanUtils.copyProperties(req, menu);
		menuService.updateById(menu);
		return ResponseResult.success();
	}

	@Override
	@GetMapping("/get")
	@ApiOperation(value = "查询菜单")
	public ResponseResult<MenuResponse> get(@RequestParam Long id) {
		Menu menu = menuService.getById(id);
		MenuResponse response = new MenuResponse();
		BeanUtils.copyProperties(menu, response);
		return ResponseResult.success(response);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation(value = "分页查询菜单")
	public ResponseResult<Leaf<MenuResponse>> list(@RequestBody MenuReq req) {
		MenuRequest request = new MenuRequest();
		BeanUtils.copyProperties(req, request);
		Page<Menu> page = menuService.list(request).getData();
		Leaf leaf = LeafPageUtil.pageToLeaf(page, MenuResponse.class);
		return ResponseResult.success(leaf);
	}

	@Override
	@PostMapping("/getmenusbyuserid")
	@ApiOperation(value = "根据用户ID查询菜单")
	public ResponseResult<Leaf<MenuResponse>> getMenusByUserId(MenuQueryReq req) {
		MenuQueryRequest request = new MenuQueryRequest();
		BeanUtils.copyProperties(req, request);
		Page<Menu> page = menuService.getMenusByUserId(request).getData();
		Leaf leaf = LeafPageUtil.pageToLeaf(page, MenuResponse.class);
		return ResponseResult.success(leaf);
	}

	@Override
	@PostMapping("/getmenusbyroleids")
	@ApiOperation(value = "根据角色ID查询菜单")
	public ResponseResult<Leaf<MenuResponse>> getMenusByRoleIds(MenuQueryReq req) {
		MenuQueryRequest request = new MenuQueryRequest();
		BeanUtils.copyProperties(req, request);
		Page<Menu> page = menuService.getMenusByRoleIds(request).getData();
		Leaf leaf = LeafPageUtil.pageToLeaf(page, MenuResponse.class);
		return ResponseResult.success(leaf);
	}

}
