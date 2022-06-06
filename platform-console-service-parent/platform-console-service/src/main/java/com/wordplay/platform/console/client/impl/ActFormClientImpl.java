package com.wordplay.platform.console.client.impl;

import com.fallframework.platform.starter.activiti.service.ActFormService;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.ActFormClient;
import com.wordplay.platform.console.model.request.StartFormDataRequest;
import com.wordplay.platform.console.model.request.TaskFormDataRequest;
import com.wordplay.platform.console.model.response.FormPropertyResponse;
import com.wordplay.platform.console.model.response.TaskFormDataResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zhuangpf
 */
public class ActFormClientImpl implements ActFormClient {

	@Autowired
	private ActFormService actFormService;

	@Override
	public ResponseResult getStartFormKey(String procDefId) {

		ResponseResult startFormKey = actFormService.getStartFormKey(procDefId);

		return null;
	}

	@Override
	public ResponseResult<List<FormPropertyResponse>> getStartFormData(String procDefId) {
		return null;
	}

	@Override
	public ResponseResult submitStartFormData(StartFormDataRequest request) {
		return null;
	}

	@Override
	public ResponseResult<TaskFormDataResponse> getTaskFormData(String taskId) {
		return null;
	}

	@Override
	public ResponseResult submitTaskFormData(TaskFormDataRequest request) {
		return null;
	}
}
