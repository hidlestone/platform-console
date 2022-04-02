package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.MenuQueryReq;
import com.wordplay.platform.console.model.request.MenuReq;
import com.wordplay.platform.console.model.response.FrontMenuResponse;
import com.wordplay.platform.console.model.response.MenuResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 菜单管理
 *
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/menu")
public interface MenuClient {

	@PostMapping("/save")
	ResponseResult save(@RequestBody MenuReq req);

	@PostMapping("/delete")
	ResponseResult delete(@RequestParam Long id);

	@PostMapping("/update")
	ResponseResult update(@RequestBody MenuReq req);

	@GetMapping("/get")
	ResponseResult<MenuResponse> get(@RequestParam Long id);

	@PostMapping("/list")
	ResponseResult<Leaf<MenuResponse>> list(@RequestBody MenuReq req);

	@PostMapping("/getmenusbyuserid")
	ResponseResult<Leaf<MenuResponse>> getMenusByUserId(@RequestBody MenuQueryReq req);

	@PostMapping("/getmenusbyroleids")
	ResponseResult<Leaf<MenuResponse>> getMenusByRoleIds(@RequestBody MenuQueryReq req);

	@GetMapping("/getallmenus")
	ResponseResult<List<FrontMenuResponse>> getAllMenus();

}
