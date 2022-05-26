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
@ApiModel("历史详细信息")
public class HistoricDetailResponse extends BaseEntityResponse {

	private static final long serialVersionUID = 5977213699769400858L;

	@ApiModelProperty("实例ID")
	protected String processInstanceId;

	@ApiModelProperty("活动实例ID")
	protected String activityInstanceId;

	@ApiModelProperty("任务ID")
	protected String taskId;

	@ApiModelProperty("执行ID")
	protected String executionId;

	@ApiModelProperty("时间")
	protected Date time;

	@ApiModelProperty("类型")
	protected String detailType;

}
