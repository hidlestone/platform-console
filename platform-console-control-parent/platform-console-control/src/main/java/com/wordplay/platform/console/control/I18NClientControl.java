package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.I18NClient;
import com.wordplay.platform.console.model.request.I18nResourceRequest;
import com.wordplay.platform.console.model.response.I18nResourceResponse;
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
@Api(tags = "I18N多语言")
@RestController
@RequestMapping("/${platform.console.control.version}/i18n")
public class I18NClientControl {

	@Autowired
	private I18NClient i18NClient;

	@PostMapping("/save")
	@ApiOperation("新增I8N词条")
	public ResponseResult save(@RequestBody I18nResourceRequest request) {
		return i18NClient.save(request);
	}

	@PostMapping("/savebatch")
	@ApiOperation("批量新增I8N词条")
	public ResponseResult saveBatch(@RequestBody List<I18nResourceRequest> reqList) {
		return i18NClient.saveBatch(reqList);
	}

	@PostMapping("/delete")
	@ApiOperation("删除I8N词条")
	public ResponseResult delete(@RequestParam Long id) {
		return i18NClient.delete(id);
	}

	@PostMapping("/update")
	@ApiOperation("修改I8N词条")
	public ResponseResult update(@RequestBody I18nResourceRequest request) {
		return i18NClient.update(request);
	}

	@GetMapping("/get")
	@ApiOperation("ID查询I8N词条")
	public ResponseResult<I18nResourceResponse> get(@RequestParam Long id) {
		return i18NClient.get(id);
	}

	@GetMapping("/getbyresourcekey")
	@ApiOperation("resourceKey查询I8N词条")
	public ResponseResult<List<I18nResourceResponse>> getByResourceKey(@RequestParam String resourceKey) {
		return i18NClient.getByResourceKey(resourceKey);
	}

	@PostMapping("/list")
	@ApiOperation("分页查询I8N词条")
	public ResponseResult<Leaf<I18nResourceResponse>> list(@RequestBody I18nResourceRequest request) {
		return i18NClient.list(request);
	}

}
