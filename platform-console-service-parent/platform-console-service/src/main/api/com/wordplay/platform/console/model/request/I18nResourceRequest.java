package com.wordplay.platform.console.model.request;

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
@ApiModel("I18N请求参数")
public class I18nResourceRequest extends BasePageRequest {

	private static final long serialVersionUID = 7878442368913931813L;

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

}
