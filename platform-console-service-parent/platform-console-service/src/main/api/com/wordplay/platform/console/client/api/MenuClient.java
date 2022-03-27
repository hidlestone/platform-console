package com.wordplay.platform.console.client.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.rbac.entity.Menu;
import com.fallframework.platform.starter.rbac.model.MenuQueryRequest;
import com.fallframework.platform.starter.rbac.model.MenuRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 菜单管理
 *
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/mailtemplate")
public interface MenuClient {

	@PostMapping("/save")
	ResponseResult save(@RequestBody MenuRequest request);

	@PostMapping("/delete")
	ResponseResult delete(@RequestParam Long id);

	@PostMapping("/update")
	ResponseResult update(@RequestBody MenuRequest request);

	@GetMapping("/get")
	ResponseResult<Menu> get(@RequestParam Long id);

	@PostMapping("/list")
	ResponseResult<Page<Menu>> list(@RequestBody MenuRequest request);

	@PostMapping("/getmenusbyuserid")
	ResponseResult<Page<Menu>> getMenusByUserId(@RequestBody MenuQueryRequest request);

	@PostMapping("/getmenusbyroleids")
	ResponseResult<Page<Menu>> getMenusByRoleIds(@RequestBody MenuQueryRequest request);
	
}
