package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.FileGroupUploadRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 本地文件上传下载
 *
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/localfileprocess")
public interface LocalFileProcessClient {

	@PostMapping("/uploadfilegroup")
	ResponseResult uploadFileGroup(FileGroupUploadRequest request);

	@PostMapping("/downloadfile")
	ResponseResult downloadFile(Long fileInfoId);

}
