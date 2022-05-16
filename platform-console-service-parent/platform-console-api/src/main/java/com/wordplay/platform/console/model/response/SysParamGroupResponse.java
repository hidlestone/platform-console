package com.wordplay.platform.console.model.response;

import com.fallframework.platform.starter.api.model.StatusEnum;
import com.fallframework.platform.starter.api.request.BasePageRequest;
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
@ApiModel("系统参数组响应参数")
public class SysParamGroupResponse extends BasePageRequest {

	private static final long serialVersionUID = 6260086277628440403L;

	@ApiModelProperty("主键")
	private Long id;

	@ApiModelProperty("系统参数组编码")
	private String code;

	@ApiModelProperty("系统参数组描述")
	private String desc;

	@ApiModelProperty("是否启用：0-停用，1-启用")
	private StatusEnum status;

	@ApiModelProperty("系统参数组明细项")
	private List<SysParamItemResponse> sysParamItems;

}
