package com.wordplay.platform.console.client.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.fallframework.platform.starter.file.entity.FileGroup;
import com.fallframework.platform.starter.file.entity.FileInfo;
import com.fallframework.platform.starter.file.model.FileGroupRequest;
import com.fallframework.platform.starter.file.service.FileGroupService;
import com.fallframework.platform.starter.file.service.FileInfoService;
import com.wordplay.platform.console.client.api.FileGroupClient;
import com.wordplay.platform.console.model.request.FileGroupReq;
import com.wordplay.platform.console.model.response.FileGroupResp;
import com.wordplay.platform.console.model.response.FileInfoResp;
import com.wordplay.platform.console.util.LeafPageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseResult delete(@RequestParam Long id) {
		fileGroupService.removeById(id);
		QueryWrapper<FileInfo> wrapper = new QueryWrapper();
		wrapper.eq("file_group_id", id);
		fileInfoService.remove(wrapper);
		return ResponseResult.success();
	}

	@Override
	@PostMapping("/get")
	@ApiOperation(value = "查询文件组及明细")
	public ResponseResult<FileGroupResp> get(@RequestParam Long id) {
		FileGroup fileGroup = fileGroupService.getById(id);
		QueryWrapper<FileInfo> wrapper = new QueryWrapper();
		wrapper.eq("file_group_id", id);
		List<FileInfo> fileInfoList = fileInfoService.list(wrapper);
		FileGroupResp fileGroupResp = new FileGroupResp();
		BeanUtils.copyProperties(fileGroup, fileGroupResp);
		List<FileInfoResp> fileInfoRespList = JSON.parseArray(JSON.toJSONString(fileInfoList), FileInfoResp.class);
		fileGroupResp.setFileInfoResponseList(fileInfoRespList);
		return ResponseResult.success(fileGroupResp);
	}

	@Override
	@PostMapping("/list")
	@ApiOperation(value = "分页查询文件组")
	public ResponseResult<Leaf<FileGroupResp>> list(@RequestBody FileGroupReq req) {
		FileGroupRequest fileGroupRequest = new FileGroupRequest();
		BeanUtils.copyProperties(req, fileGroupRequest);
		Page<FileGroup> page = fileGroupService.list(fileGroupRequest).getData();
		Leaf leaf = LeafPageUtil.pageToLeaf(page, FileGroupResp.class);
		return ResponseResult.success(leaf);
	}

}
