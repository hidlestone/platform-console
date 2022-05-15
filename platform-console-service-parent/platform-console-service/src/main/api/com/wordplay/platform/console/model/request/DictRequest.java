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
@ApiModel("字典项请求参数")
public class DictRequest extends BaseEntityRequest {

	private static final long serialVersionUID = 8921795209201188863L;

	@ApiModelProperty(value = "主键")
	private Long id;

	@ApiModelProperty(value = "字典编码")
	private String code;

	@ApiModelProperty(value = "字典描述")
	private String desc;

	@ApiModelProperty(value = "是否启用")
	private StatusEnum status;

	@ApiModelProperty("多语言词条")
	private List<I18nResourceRequest> i18nResources;
	
}
