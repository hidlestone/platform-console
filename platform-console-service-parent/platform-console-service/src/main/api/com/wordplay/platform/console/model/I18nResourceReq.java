package com.wordplay.platform.console.model;

import com.fallframework.platform.starter.api.request.BasePageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel(value = "I18N请求参数")
public class I18nResourceReq extends BasePageRequest {

	private static final long serialVersionUID = 7878442368913931813L;

	@ApiModelProperty(value = "主键")
	private Long id;

	@ApiModelProperty(value = "语言编码")
	private String langCode;

	@ApiModelProperty(value = "资源key")
	private String resourceKey;

	@ApiModelProperty(value = "资源value")
	private String resourceValue;

	@ApiModelProperty(value = "所属module")
	private String moduleCode;

}
