package com.wordplay.platform.console.model.response;

import com.fallframework.platform.starter.api.response.BaseEntityResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel("历史任务实例响应参数")
public class HistoricTaskInstanceResponse extends BaseEntityResponse {

	private static final long serialVersionUID = -2869091608266408474L;

	@ApiModelProperty("执行ID")
	private String executionId;

	@ApiModelProperty("名称")
	private String name;

	@ApiModelProperty("本地化名称")
	private String localizedName;

	@ApiModelProperty("父任务ID")
	private String parentTaskId;

	@ApiModelProperty("描述")
	private String description;

	@ApiModelProperty("本地化描述")
	private String localizedDescription;

	@ApiModelProperty("拥有者")
	private String owner;

	@ApiModelProperty("任务指派者")
	private String assignee;

	@ApiModelProperty("任务定义key")
	private String taskDefinitionKey;

	@ApiModelProperty("表单key")
	private String formKey;

	@ApiModelProperty("优先级")
	private int priority;

	@ApiModelProperty("截止日期")
	private Date dueDate;

	@ApiModelProperty("声明时间")
	private Date claimTime;

	@ApiModelProperty("分类")
	private String category;

	@ApiModelProperty("租户ID")
	private String tenantId = "";

}
