package com.wordplay.platform.console.model.response;

import com.fallframework.platform.starter.api.response.BaseEntityResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel("表单信息响应参数")
public class FormPropertyResponse extends BaseEntityResponse {

	private static final long serialVersionUID = -3614895072279600368L;

	@ApiModelProperty("ID")
	protected String id;

	@ApiModelProperty("名称")
	protected String name;

	@ApiModelProperty("是否需要")
	protected boolean isRequired;

	@ApiModelProperty("是否刻可读")
	protected boolean isReadable;

	@ApiModelProperty("是否可写")
	protected boolean isWritable;

	@ApiModelProperty("值")
	protected String value;

}
