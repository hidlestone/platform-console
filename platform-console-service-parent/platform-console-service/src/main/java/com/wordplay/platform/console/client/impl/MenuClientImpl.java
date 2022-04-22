package com.wordplay.platform.console.client.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.rbac.entity.Menu;
import com.fallframework.platform.starter.rbac.entity.User;
import com.fallframework.platform.starter.rbac.model.MenuQueryRequest;
import com.fallframework.platform.starter.rbac.model.MenuRequest;
import com.fallframework.platform.starter.rbac.service.MenuService;
import com.fallframework.platform.starter.rbac.util.RequestContexUtil;
import com.fallframework.platform.starter.shiro.util.JWTUtil;
import com.wordplay.platform.console.client.api.MenuClient;
import com.wordplay.platform.console.model.request.MenuQueryReq;
import com.wordplay.platform.console.model.request.MenuReq;
import com.wordplay.platform.console.model.response.FrontMenuResponse;
import com.wordplay.platform.console.model.response.MenuMetaInfoResponse;
import com.wordplay.platform.console.model.response.MenuResponse;
import com.wordplay.platform.console.util.LeafPageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhuangpf
 */
@Api(tags = "菜单管理")
@RestController
@RequestMapping("/${platform.console.service.version}/menu")
public class MenuClientImpl implements MenuClient {

	@Autowired
	private MenuService menuService;
	@Autowired
	private JWTUtil jwtUtil;

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
	@ApiOperation(value = "根据用户ID分页查询菜单")
	public ResponseResult<Leaf<MenuResponse>> getMenusByUserId(@RequestBody MenuQueryReq req) {
		MenuQueryRequest request = new MenuQueryRequest();
		BeanUtils.copyProperties(req, request);
		Page<Menu> page = menuService.getMenusByUserId(request).getData();
		Leaf leaf = LeafPageUtil.pageToLeaf(page, MenuResponse.class);
		return ResponseResult.success(leaf);
	}

	@Override
	@PostMapping("/getmenusbyroleids")
	@ApiOperation(value = "根据角色ID分页查询菜单")
	public ResponseResult<Leaf<MenuResponse>> getMenusByRoleIds(@RequestBody MenuQueryReq req) {
		MenuQueryRequest request = new MenuQueryRequest();
		BeanUtils.copyProperties(req, request);
		Page<Menu> page = menuService.getMenusByRoleIds(request).getData();
		Leaf leaf = LeafPageUtil.pageToLeaf(page, MenuResponse.class);
		return ResponseResult.success(leaf);
	}

	@Override
	@GetMapping("/getallmenus")
	@ApiOperation(value = "根据token获取当前用户所有菜单")
	public ResponseResult<List<FrontMenuResponse>> getAllMenus() {
		// TODO
		Subject currentUser = SecurityUtils.getSubject();
		User curUser = (User) currentUser.getPrincipal();
		String accesstoken = RequestContexUtil.getAccesstoken();
		if (StringUtils.isEmpty(accesstoken)) {
			return ResponseResult.fail("token不存在");
		}
		try {
			curUser = jwtUtil.parseToken(accesstoken);
			if (null == curUser) {
				return ResponseResult.fail("用户不存在");
			}
		} catch (Exception e) {
			return ResponseResult.fail("token不可用");
		}
		// 获取当前用户所有可访问的菜单
		List<Menu> menuList = menuService.getAllMenusByUserId(curUser.getId()).getData();
		if (CollectionUtil.isEmpty(menuList)) {
			return ResponseResult.fail("菜单不存在");
		}
		// 转换成前端展示的数据结构
		List<FrontMenuResponse> oneMenuResponseList = new ArrayList<>();
		// 一级菜单，即parentId为null，按照order降序
		List<Menu> oneMenuList = menuList.stream().filter(e -> null == e.getParentId()).sorted(Comparator.comparing(Menu::getOrder)).collect(Collectors.toList());
		if (CollectionUtil.isEmpty(oneMenuList)) {
			return ResponseResult.fail("一级菜单不存在");
		}
		for (Menu menu : oneMenuList) {
			FrontMenuResponse oneFrontMenu = menuToFrontMenu(menu);
			oneFrontMenu.setComponent("Layout");
			oneFrontMenu.setRedirect(menu.getFuncLink());
			oneMenuResponseList.add(oneFrontMenu);
			// 二级菜单
			List<FrontMenuResponse> twoMenuResponseList = new ArrayList<>();
			List<Menu> twoMenuList = menuList.stream().filter(e -> menu.getId().equals(e.getParentId())).sorted(Comparator.comparing(Menu::getOrder)).collect(Collectors.toList());
			for (Menu menu2 : twoMenuList) {
				FrontMenuResponse twoFrontMenu = menuToFrontMenu(menu2);
				twoFrontMenu.setComponent(menu2.getFuncLink());
				twoMenuResponseList.add(twoFrontMenu);
			}
			oneFrontMenu.setChildren(twoMenuResponseList);
		}
		return ResponseResult.success(oneMenuResponseList);
	}

	@Override
	public ResponseResult<List<MenuResponse>> getMenuTree(MenuQueryReq req) {
		MenuQueryRequest request = new MenuQueryRequest();
		BeanUtils.copyProperties(req, request);
		ResponseResult<List<Menu>> menuTreeList = menuService.getMenuTree(request);
		List<MenuResponse> menuResponseList = JSON.parseArray(JSON.toJSONString(menuTreeList), MenuResponse.class);
		return ResponseResult.success(menuResponseList);
	}

	@Override
	public ResponseResult<List<Menu>> getMenuListByParentId(Long parentId) {
		return menuService.getMenuListByParentId(parentId);
	}

	/**
	 * 转换成前端展示的字段
	 *
	 * @param menu 菜单对象
	 * @return 前端展示的菜单数据
	 */
	public FrontMenuResponse menuToFrontMenu(Menu menu) {
		FrontMenuResponse frontMenu = new FrontMenuResponse();
		frontMenu.setPath(menu.getPath());
		/*frontMenu.setRedirect(menu.getFuncLink());*/
		frontMenu.setAlwaysShow(true);
		frontMenu.setName(menu.getMenuName());
		MenuMetaInfoResponse meta = new MenuMetaInfoResponse();
		meta.setTitle(menu.getMenuName());
		meta.setIcon(menu.getIcon());
		/*meta.setRoles();*/
		frontMenu.setMeta(meta);
		return frontMenu;
	}

}
