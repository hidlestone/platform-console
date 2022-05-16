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
@ApiModel("邮件模板请求参数")
public class MailTemplateRequest extends BasePageRequest {

	private static final long serialVersionUID = -734434411782269463L;

	@ApiModelProperty("ID")
	private Long id;

	@ApiModelProperty("邮件模板配置编码")
	private String code;

	@ApiModelProperty("邮件模板配置描述")
	private String desc;

	@ApiModelProperty("标题")
	private String title;

	@ApiModelProperty("发送者")
	private String from;

	@ApiModelProperty("内容")
	private String content;

	@ApiModelProperty("文件组ID")
	private Long fileGroupId;

	@ApiModelProperty("重试次数")
	private Byte retryCount;

}
