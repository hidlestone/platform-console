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
@ApiModel("开始表单请求参数")
public class StartFormDataRequest extends BasePageRequest {

	private static final long serialVersionUID = -2815274613021415755L;

	@ApiModelProperty("流程定义ID")
	private String procDefId;

	@ApiModelProperty("参数")
	private Map<String, String> properties;

}
