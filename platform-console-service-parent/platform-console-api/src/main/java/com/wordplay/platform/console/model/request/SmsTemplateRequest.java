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
@ApiModel("短信模板请求参数")
public class SmsTemplateRequest extends BasePageRequest {

	private static final long serialVersionUID = -1097471572487020453L;

	@ApiModelProperty("主键")
	private Long id;

	@ApiModelProperty("短信模板配置描述")
	private String desc;

	@ApiModelProperty("发送号码")
	private String from;

	@ApiModelProperty("0-简单，1-模板")
	private Byte contentType;

	@ApiModelProperty("内容")
	private String content;

	@ApiModelProperty("文件组ID")
	private Long fileGroupId;

	@ApiModelProperty("重试次数")
	private Byte retryCount;

}
