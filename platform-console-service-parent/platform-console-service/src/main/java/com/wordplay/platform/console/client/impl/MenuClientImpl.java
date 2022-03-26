package com.wordplay.platform.console.client.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.rbac.entity.Menu;
import com.fallframework.platform.starter.rbac.model.MenuRequest;
import com.fallframework.platform.starter.rbac.service.MenuService;
import com.wordplay.platform.console.client.api.MenuClient;
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
@RequestMapping("/menu")
public class MenuClientImpl implements MenuClient {

	@Autowired
	private MenuService menuService;

	@Override
	@PostMapping("/save")
	@ApiOperation(value = "保存菜单")
	public ResponseResult save(@RequestBody MenuRequest request) {
		Menu menu = new Menu();
		BeanUtils.copyProperties(request, menu);
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
	public ResponseResult update(@RequestBody MenuRequest request) {
		Menu menu = new Menu();
		BeanUtils.copyProperties(request, menu);
		menuService.updateById(menu);
		return ResponseResult.success();
	}

	@Override
	@GetMapping("/get")
	@ApiOperation(value = "查询菜单")
	public ResponseResult<Menu> get(@RequestParam Long id) {
		Menu menu = menuService.getById(id);
		return ResponseResult.success(menu);
	}

	@Override
	@GetMapping("/list")
	@ApiOperation(value = "分页查询菜单")
	public ResponseResult<Page<Menu>> list(@RequestBody MenuRequest request) {
		return menuService.list(request);
	}
	
}
