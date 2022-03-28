package com.wordplay.platform.console.model.request;

import com.fallframework.platform.starter.api.model.StatusEnum;
import com.fallframework.platform.starter.api.request.BaseEntityRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel("系统参数明细项请求参数")
public class SysParamItemReq extends BaseEntityRequest {

	private static final long serialVersionUID = -8814225938153234154L;

	@ApiModelProperty("系统参数编码")
	private String code;

	@ApiModelProperty("系统参数值")
	private String value;

	@ApiModelProperty("加密值")
	private String encryptedValue;

	@ApiModelProperty("系统参数描述")
	private String desc;

	@ApiModelProperty("是否启用：0-停用，1-启用")
	private StatusEnum status;

	@ApiModelProperty("系统参数组编码")
	private String groupCode;

}
