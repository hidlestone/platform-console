package com.wordplay.platform.console.model.request;

import com.fallframework.platform.starter.api.model.StatusEnum;
import com.fallframework.platform.starter.api.request.BaseEntityRequest;
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
@ApiModel("字典明细请求参数")
public class DictDtlRequest extends BaseEntityRequest {

	private static final long serialVersionUID = -23371832862426531L;

	/**
	 * 主键
	 */
	@ApiModelProperty(value = "主键")
	private Long id;

	/**
	 * 字典项ID
	 */
	@ApiModelProperty(value = "字典项ID")
	private Long dictId;

	/**
	 * 字典编码
	 */
	@ApiModelProperty(value = "字典编码")
	private String code;

	/**
	 * 是否启用
	 */
	@ApiModelProperty(value = "是否启用")
	private StatusEnum status;

	@ApiModelProperty("多语言词条")
	private List<I18nResourceRequest> i18nResources;

}
