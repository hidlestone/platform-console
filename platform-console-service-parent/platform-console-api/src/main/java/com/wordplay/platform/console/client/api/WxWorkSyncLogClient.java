package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.WxWorkSyncLogRequest;
import com.wordplay.platform.console.model.response.WxWorkSyncLogResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 企微-通讯录-同步日志
 *
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/wxworksynclog")
public interface WxWorkSyncLogClient {

	@GetMapping("/get")
	ResponseResult<WxWorkSyncLogResponse> get(@RequestParam Long id);

	@PostMapping("/list")
	ResponseResult<Leaf<WxWorkSyncLogResponse>> list(@RequestBody WxWorkSyncLogRequest request);

}
