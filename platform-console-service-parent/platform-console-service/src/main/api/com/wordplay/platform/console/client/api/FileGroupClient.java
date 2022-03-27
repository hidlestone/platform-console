package com.wordplay.platform.console.client.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.file.entity.FileGroup;
import com.fallframework.platform.starter.file.model.FileGroupResponse;
import com.wordplay.platform.console.model.FileGroupReq;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 文件组管理
 *
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/filegroup")
public interface FileGroupClient {

	@PostMapping("/delete")
	ResponseResult delete(@RequestParam Long id);

	@GetMapping("/get")
	ResponseResult<FileGroupResponse> get(@RequestParam Long id);

	@PostMapping("/list")
	ResponseResult<Page<FileGroup>> list(@RequestBody FileGroupReq req);

}
