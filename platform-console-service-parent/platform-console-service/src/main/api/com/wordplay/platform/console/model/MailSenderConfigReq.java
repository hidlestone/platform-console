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
@ApiModel(value = "邮件配置请求参数")
public class MailSenderConfigReq extends BasePageRequest {

	private static final long serialVersionUID = -5804463321305692737L;

	@ApiModelProperty(value = "如：smtp.163.com")
	private String host;

	@ApiModelProperty(value = "端口")
	private Integer port;

	@ApiModelProperty(value = "账号")
	private String username;

	@ApiModelProperty(value = "密码")
	private String password;

	@ApiModelProperty(value = "协议")
	private String protocol = "smtp";

	@ApiModelProperty(value = "默认编码")
	private String defaultEncoding = "UTF-8";

	@ApiModelProperty(value = "其他的参数配置(JSON格式)")
	private String properties;

}
