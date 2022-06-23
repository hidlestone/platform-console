package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.WxWorkSyncLogClient;
import com.wordplay.platform.console.model.request.WxWorkSyncLogRequest;
import com.wordplay.platform.console.model.response.WxWorkSyncLogResponse;
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
@Api(tags = "企微-通讯录-同步日志")
@RestController
@RequestMapping("/${platform.console.control.version}/wxworksynclog")
public class WxWorkSyncLogControl {

	@Autowired
	private WxWorkSyncLogClient wxWorkSyncLogClient;

	@GetMapping("/get")
	@ApiOperation("查询同步日志")
	public ResponseResult<WxWorkSyncLogResponse> get(@RequestParam Long id) {
		return wxWorkSyncLogClient.get(id);
	}

	@PostMapping("/list")
	@ApiOperation("分页查询同步日志")
	public ResponseResult<Leaf<WxWorkSyncLogResponse>> list(@RequestBody WxWorkSyncLogRequest request) {
		return wxWorkSyncLogClient.list(request);
	}
	
}
