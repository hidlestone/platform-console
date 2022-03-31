package com.wordplay.platform.console.control;

import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.LocalFileProcessClient;
import com.wordplay.platform.console.model.request.FileGroupUploadReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuangpf
 */
@Api(tags = "本地文件上传下载")
@RestController
@RequestMapping("/${platform.console.control.version}/localfileprocess")
public class LocalFileProcessControl {

	@Autowired
	private LocalFileProcessClient localFileProcessClient;

	@PostMapping("/uploadfilegroup")
	@ApiOperation(value = "上传文件组")
	public ResponseResult uploadFileGroup(FileGroupUploadReq req) {
		return localFileProcessClient.uploadFileGroup(req);
	}

	@PostMapping("/downloadfile")
	@ApiOperation(value = "下载文件")
	public ResponseResult downloadFile(Long fileInfoId) {
		return localFileProcessClient.downloadFile(fileInfoId);
	}

}
