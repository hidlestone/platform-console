package com.wordplay.platform.console.model.request;

import com.fallframework.platform.starter.api.request.BasePageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel("任务表单表单请求参数")
public class TaskFormDataRequest extends BasePageRequest {

	private static final long serialVersionUID = 7209626921888478743L;

	@ApiModelProperty("任务ID")
	private String taskId;

	@ApiModelProperty("参数")
	private Map<String, String> properties;
}
