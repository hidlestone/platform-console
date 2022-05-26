package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.AssignTaskRequest;
import com.wordplay.platform.console.model.request.CompleteTaskRequest;
import com.wordplay.platform.console.model.request.PendingTaskRequest;
import com.wordplay.platform.console.model.request.RejectTaskRequest;
import com.wordplay.platform.console.model.request.TaskQueryRequest;
import com.wordplay.platform.console.model.response.TaskResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/acttask")
public interface ActTaskClient {

	/**
	 * 分页查询任务
	 *
	 * @param request 请求参数
	 * @return 任务列表分页
	 */
	@PostMapping("/gettasklist")
	ResponseResult<Leaf<TaskResponse>> getTaskList(@RequestBody TaskQueryRequest request);

	/**
	 * 查询用户待处理任务列表
	 *
	 * @param request 请求参数
	 * @return 待处理任务列表
	 */
	@PostMapping("/getpendingtasklist")
	ResponseResult<Leaf<TaskResponse>> getPendingTaskList(@RequestBody PendingTaskRequest request);

	/**
	 * 完成任务
	 *
	 * @param request 请求参数
	 * @return 是否成功
	 */
	@PostMapping("/complettask")
	ResponseResult completTask(@RequestBody CompleteTaskRequest request);

	/**
	 * 任务驳回
	 *
	 * @param request 请求参数
	 * @return 是否成功
	 */
	@PostMapping("/rejecttask")
	ResponseResult rejectTask(@RequestBody RejectTaskRequest request);

	/**
	 * 指派任务
	 *
	 * @param request 请求参数
	 * @return 是否成功
	 */
	@PostMapping("/assigntask")
	ResponseResult assignTask(@RequestBody AssignTaskRequest request);

	/**
	 * 获取任务详细信息
	 *
	 * @param taskId 任务ID
	 * @return 任务详细信息
	 */
	@GetMapping("/gettaskdetail")
	ResponseResult getTaskDetail(@RequestParam String taskId);

}
