package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.StartFormDataRequest;
import com.wordplay.platform.console.model.request.TaskFormDataRequest;
import com.wordplay.platform.console.model.response.FormPropertyResponse;
import com.wordplay.platform.console.model.response.TaskFormDataResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/actform")
public interface ActFormClient {

	/**
	 * startFormKey对应流程文件中的startEvent中的属性activiti:formKey
	 *
	 * @param procDefId 流程定义ID
	 * @return startFormKey
	 */
	@GetMapping("/getstartformkey")
	ResponseResult getStartFormKey(@RequestParam String procDefId);

	/**
	 * 获取表单信息
	 *
	 * @param procDefId 流程定义ID
	 * @return 表单信息
	 */
	@GetMapping("/getstartformdata")
	ResponseResult<List<FormPropertyResponse>> getStartFormData(@RequestParam String procDefId);

	/**
	 * 提交开始的表单数据
	 *
	 * @param request 请求参数
	 * @return 是否提交成功
	 */
	@PostMapping("/submitartformdata")
	ResponseResult submitStartFormData(@RequestBody StartFormDataRequest request);

	/**
	 * 根据任务ID获取表单数据
	 *
	 * @param taskId 任务ID
	 * @return 任务表单数据
	 */
	@GetMapping("/gettaskformdata")
	ResponseResult<TaskFormDataResponse> getTaskFormData(@RequestParam String taskId);

	/**
	 * 提交任务的表单数据
	 *
	 * @param request 请求参数
	 * @rern 是否提交成功
	 */
	@PostMapping("/submittaskformdata")
	ResponseResult submitTaskFormData(@RequestBody TaskFormDataRequest request);

}
