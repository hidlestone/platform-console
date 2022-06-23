package com.wordplay.platform.console.client.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.data.mp.util.LeafPageUtil;
import com.fallframework.platform.starter.wechatwork.entity.SyncLog;
import com.fallframework.platform.starter.wechatwork.service.SyncLogService;
import com.wordplay.platform.console.client.api.WxWorkSyncLogClient;
import com.wordplay.platform.console.model.request.WxWorkSyncLogRequest;
import com.wordplay.platform.console.model.response.WxWorkSyncLogResponse;
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
@Api(tags = "企微-通讯录-同步日志")
@RestController
@RequestMapping("/${platform.console.service.version}/wxworksynclog")
public class WxWorkSyncLogClientImpl implements WxWorkSyncLogClient {

	@Autowired
	private SyncLogService syncLogService;

	@Override
	@GetMapping("/get")
	@ApiOperation("查询同步日志")
	public ResponseResult<WxWorkSyncLogResponse> get(@RequestParam Long id) {
		SyncLog syncLog = syncLogService.getById(id);
		WxWorkSyncLogResponse response = new WxWorkSyncLogResponse();
		BeanUtils.copyProperties(syncLog, response);
		return ResponseResult.success(response);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation("分页查询同步日志")
	public ResponseResult<Leaf<WxWorkSyncLogResponse>> list(@RequestBody WxWorkSyncLogRequest request) {
		SyncLog syncLog = new SyncLog();
		BeanUtils.copyProperties(request, syncLog);
		Page<SyncLog> page = syncLogService.list(syncLog).getData();
		Leaf leaf = LeafPageUtil.pageToLeaf(page, WxWorkSyncLogResponse.class);
		return ResponseResult.success(leaf);
	}

}
