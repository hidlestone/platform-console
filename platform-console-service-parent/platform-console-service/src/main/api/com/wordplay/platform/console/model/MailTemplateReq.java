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
@ApiModel(value = "邮件模板请求参数")
public class MailTemplateReq extends BasePageRequest {

	private static final long serialVersionUID = -734434411782269463L;

	@ApiModelProperty(value = "邮件模板配置编码")
	private String code;

	@ApiModelProperty(value = "邮件模板配置描述")
	private String desc;

	@ApiModelProperty(value = "标题")
	private String title;

	@ApiModelProperty(value = "发送者")
	private String from;

	@ApiModelProperty(value = "内容")
	private String content;

	@ApiModelProperty(value = "文件组ID")
	private Long fileGroupId;

	@ApiModelProperty(value = "重试次数")
	private Byte retryCount;

}
