package com.wordplay.platform.console.client.impl;

import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.file.model.FileGroupUploadDto;
import com.fallframework.platform.starter.file.service.FileProcessService;
import com.wordplay.platform.console.client.api.LocalFileProcessClient;
import com.wordplay.platform.console.model.request.FileGroupUploadRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;

/**
 * @author zhuangpf
 */
@Api(tags = "本地文件处理")
@RestController
@RequestMapping("/${platform.console.service.version}/localfileprocess")
public class LocalFileProcessClientImpl implements LocalFileProcessClient {

	@Autowired
	private FileProcessService fileProcessService;

	@Override
	@PostMapping("/uploadfilegroup")
	@ApiOperation(value = "上传文件组")
	public ResponseResult uploadFileGroup(FileGroupUploadRequest req) {
		FileGroupUploadDto dto = new FileGroupUploadDto();
		BeanUtils.copyProperties(req, dto);
		return fileProcessService.uploadFileGroup(dto);
	}

	@Override
	@PostMapping("/downloadfile")
	@ApiOperation(value = "下载文件")
	public ResponseResult downloadFile(Long fileInfoId) {
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
		return fileProcessService.downloadFile(fileInfoId, response);
	}

}
