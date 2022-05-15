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
@ApiModel("系统参数明细项响应参数")
public class SysParamItemResponse extends BaseEntityResponse {

	private static final long serialVersionUID = 7089403853723764028L;

	@ApiModelProperty("系统参数编码")
	private String code;

	@ApiModelProperty("系统参数值")
	private String value;

	@ApiModelProperty("加密值")
	private String encryptedValue;

	@ApiModelProperty("系统参数描述")
	private String desc;

	@ApiModelProperty("是否启用：0-停用，1-启用")
	private Boolean status;

	@ApiModelProperty("系统参数组编码")
	private String groupCode;

	@ApiModelProperty("创建用户ID")
	private Long createUserId;

	@ApiModelProperty("修改用户ID")
	private Long modifyUserId;

	@ApiModelProperty("创建时间")
	private Date gmtCreate;

	@ApiModelProperty("更改时间")
	private Date gmtModified;

}
