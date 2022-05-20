package com.wordplay.platform.console.model.response;

import com.fallframework.platform.starter.api.model.StatusEnum;
import com.fallframework.platform.starter.api.response.BaseEntityResponse;
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
@ApiModel("字典项响应参数")
public class DictResponse extends BaseEntityResponse {

	private static final long serialVersionUID = 5328299430439282758L;

	@ApiModelProperty("主键")
	private Long id;

	@ApiModelProperty("字典编码")
	private String code;

	@ApiModelProperty("字典描述")
	private String desc;

	@ApiModelProperty("是否启用")
	private StatusEnum status;

	@ApiModelProperty("字典项明细")
	private List<DictDtlResponse> dictDtls;

}
