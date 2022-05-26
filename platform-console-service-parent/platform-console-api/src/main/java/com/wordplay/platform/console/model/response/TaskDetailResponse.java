package com.wordplay.platform.console.model.response;

import com.fallframework.platform.starter.api.response.BaseEntityResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel("任务详细信息")
public class TaskDetailResponse extends BaseEntityResponse {

	private static final long serialVersionUID = 4741799794566009527L;

	@ApiModelProperty("任务")
	private TaskResponse task;

	@ApiModelProperty("表单信息")
	private List<FormPropertyResponse> formProperties;

}
