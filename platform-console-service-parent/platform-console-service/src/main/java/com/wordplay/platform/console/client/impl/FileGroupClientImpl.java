package com.wordplay.platform.console.client.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.file.entity.FileGroup;
import com.fallframework.platform.starter.file.entity.FileInfo;
import com.fallframework.platform.starter.file.model.FileGroupRequest;
import com.fallframework.platform.starter.file.model.FileGroupResponse;
import com.fallframework.platform.starter.file.model.FileInfoResponse;
import com.fallframework.platform.starter.file.service.FileGroupService;
import com.fallframework.platform.starter.file.service.FileInfoService;
import com.wordplay.platform.console.client.api.FileGroupClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhuangpf
 */
@Api(tags = "文件组管理")
@RestController
@RequestMapping("/${platform.console.service.version}/filegroup")
public class FileGroupClientImpl implements FileGroupClient {

	@Autowired
	private FileGroupService fileGroupService;
	@Autowired
	private FileInfoService fileInfoService;

	@Override
	@PostMapping("/delete")
	@ApiOperation(value = "删除文件组及明细")
	public ResponseResult delete(Long id) {
		fileGroupService.removeById(id);
		QueryWrapper<FileInfo> wrapper = new QueryWrapper();
		wrapper.eq("file_group_id", id);
		fileInfoService.remove(wrapper);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/get")
	@ApiOperation(value = "查询文件组及明细")
	public ResponseResult<FileGroupResponse> get(Long id) {
		FileGroup fileGroup = fileGroupService.getById(id);
		QueryWrapper<FileInfo> wrapper = new QueryWrapper();
		wrapper.eq("file_group_id", id);
		List<FileInfo> fileInfoList = fileInfoService.list(wrapper);
		FileGroupResponse fileGroupResponse = new FileGroupResponse();
		BeanUtils.copyProperties(fileGroup, fileGroupResponse);
		List<FileInfoResponse> fileInfoResponseList = JSON.parseArray(JSON.toJSONString(fileInfoList), FileInfoResponse.class);
		fileGroupResponse.setFileInfoResponseList(fileInfoResponseList);
		return ResponseResult.success(fileGroupResponse);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation(value = "分页查询文件组")
	public ResponseResult<Page<FileGroup>> list(FileGroupRequest request) {
		return fileGroupService.list(request);
	}

}
