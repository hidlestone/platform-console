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
@ApiModel("已启动任务的历史活动信息")
public class HistoricActivityResponse extends BaseEntityResponse {

	private static final long serialVersionUID = 4053769524668851272L;

	@ApiModelProperty("活动信息")
	private HistoricTaskInstanceResponse historicActivityInstance;

	@ApiModelProperty("活动信息明细")
	private List<HistoricDetailResponse> historicDetailList;

}
