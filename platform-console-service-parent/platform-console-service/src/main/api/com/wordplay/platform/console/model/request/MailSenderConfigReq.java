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
@ApiModel("邮件配置请求参数")
public class MailSenderConfigReq extends BasePageRequest {

	private static final long serialVersionUID = -5804463321305692737L;

	@ApiModelProperty("如：smtp.163.com")
	private String host;

	@ApiModelProperty("端口")
	private Integer port;

	@ApiModelProperty("账号")
	private String username;

	@ApiModelProperty("密码")
	private String password;

	@ApiModelProperty("协议")
	private String protocol = "smtp";

	@ApiModelProperty("默认编码")
	private String defaultEncoding = "UTF-8";

	@ApiModelProperty("其他的参数配置(JSON格式)")
	private String properties;

}
