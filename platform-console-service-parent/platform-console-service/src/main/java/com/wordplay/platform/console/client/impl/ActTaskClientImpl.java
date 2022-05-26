package com.wordplay.platform.console.client.impl;

import com.fallframework.platform.starter.activiti.model.AssignTaskDto;
import com.fallframework.platform.starter.activiti.model.CompleteTaskDto;
import com.fallframework.platform.starter.activiti.model.PendingTaskDto;
import com.fallframework.platform.starter.activiti.model.RejectTaskDto;
import com.fallframework.platform.starter.activiti.model.TaskQueryDto;
import com.fallframework.platform.starter.activiti.service.ActTaskService;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.ActTaskClient;
import com.wordplay.platform.console.model.request.AssignTaskRequest;
import com.wordplay.platform.console.model.request.CompleteTaskRequest;
import com.wordplay.platform.console.model.request.PendingTaskRequest;
import com.wordplay.platform.console.model.request.RejectTaskRequest;
import com.wordplay.platform.console.model.request.TaskQueryRequest;
import com.wordplay.platform.console.model.response.TaskResponse;
import com.wordplay.platform.console.util.LeafPageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.activiti.engine.task.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author zhuangpf
 */
@Api(tags = "流程任务")
@RestController
@RequestMapping("/${platform.console.service.version}/acttask")
public class ActTaskClientImpl implements ActTaskClient {

	@Autowired
	private ActTaskService actTaskService;

	@Override
	@PostMapping("/gettasklist")
	@ApiOperation(value = "分页查询任务")
	public ResponseResult<Leaf<TaskResponse>> getTaskList(TaskQueryRequest request) {
		TaskQueryDto dto = new TaskQueryDto();
		BeanUtils.copyProperties(request, dto);
		Leaf<Task> page = actTaskService.getTaskList(dto).getData();
		Leaf<TaskResponse> leaf = LeafPageUtil.leafToType(page, TaskResponse.class);
		return ResponseResult.success(leaf);
	}

	@Override
	@PostMapping("/getpendingtasklist")
	@ApiOperation(value = "查询用户待处理任务列表")
	public ResponseResult<Leaf<TaskResponse>> getPendingTaskList(PendingTaskRequest request) {
		PendingTaskDto dto = new PendingTaskDto();
		BeanUtils.copyProperties(request, dto);
		Leaf<Task> page = actTaskService.getPendingTaskList(dto).getData();
		Leaf<TaskResponse> leaf = LeafPageUtil.leafToType(page, TaskResponse.class);
		return ResponseResult.success(leaf);
	}

	@Override
	@PostMapping("/complettask")
	@ApiOperation(value = "完成任务")
	public ResponseResult completTask(@RequestBody CompleteTaskRequest request) {
		CompleteTaskDto dto = new CompleteTaskDto();
		BeanUtils.copyProperties(request, dto);
		return actTaskService.completTask(dto);
	}

	@Override
	@PostMapping("/rejecttask")
	@ApiOperation(value = "任务驳回")
	public ResponseResult rejectTask(RejectTaskRequest request) {
		RejectTaskDto dto = new RejectTaskDto();
		BeanUtils.copyProperties(request, dto);
		return actTaskService.rejectTask(dto);
	}

	@Override
	@PostMapping("/assigntask")
	@ApiOperation(value = "指派任务")
	public ResponseResult assignTask(AssignTaskRequest request) {
		AssignTaskDto dto = new AssignTaskDto();
		BeanUtils.copyProperties(request, dto);
		return actTaskService.assignTask(dto);
	}

	@Override
	@PostMapping("/getTaskDetail")
	@ApiOperation(value = "获取任务详细信息")
	public ResponseResult getTaskDetail(String taskId) {
		return null;
	}
	
}
