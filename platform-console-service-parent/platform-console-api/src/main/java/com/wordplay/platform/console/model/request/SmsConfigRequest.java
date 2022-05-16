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
@ApiModel("短信配置请求参数")
public class SmsConfigRequest extends BasePageRequest {

	private static final long serialVersionUID = -3587548184906708456L;

	@ApiModelProperty("主键")
	private Long id;

	@ApiModelProperty("使用的短信产品类型")
	private String productType;

	@ApiModelProperty("区域ID")
	private String regionId;

	@ApiModelProperty("accessKeyId")
	private String accessKeyId;

	@ApiModelProperty("accessKeySecret")
	private String accessKeySecret;

	@ApiModelProperty("其他的参数配置(JSON格式)")
	private String properties;

}
