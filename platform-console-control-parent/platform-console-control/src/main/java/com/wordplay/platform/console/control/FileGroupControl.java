package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.FileGroupClient;
import com.wordplay.platform.console.model.request.FileGroupRequest;
import com.wordplay.platform.console.model.response.FileGroupResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuangpf
 */
@Api(tags = "文件组管理")
@RestController
@RequestMapping("/${platform.console.control.version}/filegroup")
public class FileGroupControl {

	@Autowired
	private FileGroupClient fileGroupClient;

	@PostMapping("/delete")
	@ApiOperation("删除文件组及明细")
	public ResponseResult delete(@RequestParam Long id) {
		return fileGroupClient.delete(id);
	}

	@PostMapping("/get")
	@ApiOperation("查询文件组及明细")
	public ResponseResult<FileGroupResponse> get(@RequestParam Long id) {
		return fileGroupClient.get(id);
	}

	@PostMapping("/list")
	@ApiOperation("分页查询文件组")
	public ResponseResult<Leaf<FileGroupResponse>> list(@RequestBody FileGroupRequest request) {
		return fileGroupClient.list(request);
	}

}
