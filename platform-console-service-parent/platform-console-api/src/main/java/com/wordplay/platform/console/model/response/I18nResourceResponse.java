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
@ApiModel("I18N响应参数")
public class I18nResourceResponse extends BaseEntityResponse {

	private static final long serialVersionUID = 5429283847381527556L;

	@ApiModelProperty("主键")
	private Long id;

	@ApiModelProperty("语言编码")
	private String langCode;

	@ApiModelProperty("资源key")
	private String resourceKey;

	@ApiModelProperty("资源value")
	private String resourceValue;

	@ApiModelProperty("所属module")
	private String moduleCode;

	@ApiModelProperty("创建用户ID")
	private Long createUserId;

	@ApiModelProperty("修改用户ID")
	private Long modifyUserId;

	@ApiModelProperty("创建时间")
	private Date gmtCreate;

	@ApiModelProperty("更改时间")
	private Date gmtModified;

}
