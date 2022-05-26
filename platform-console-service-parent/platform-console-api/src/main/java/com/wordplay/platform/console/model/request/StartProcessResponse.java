package com.wordplay.platform.console.model.request;

import com.fallframework.platform.starter.api.response.BaseEntityResponse;
import com.wordplay.platform.console.model.response.FormPropertyResponse;
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
@ApiModel("跳转流程开启页携带的表单信息")
public class StartProcessResponse extends BaseEntityResponse {

	private static final long serialVersionUID = 7307907859920703125L;

	@ApiModelProperty("流程定义ID")
	private String procDefId;

	@ApiModelProperty("表单信息")
	private List<FormPropertyResponse> formProperties;

	public StartProcessResponse(String procDefId, List<FormPropertyResponse> formProperties) {
		this.procDefId = procDefId;
		this.formProperties = formProperties;
	}

}
