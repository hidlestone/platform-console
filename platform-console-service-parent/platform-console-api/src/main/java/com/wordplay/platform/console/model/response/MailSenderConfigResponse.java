package com.wordplay.platform.console.model.response;

import com.fallframework.platform.starter.api.response.BaseEntityResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel("邮件配置响应参数")
public class MailSenderConfigResponse extends BaseEntityResponse {

	private static final long serialVersionUID = 6572731948694009814L;

	@ApiModelProperty("主键")
	private Long id;

	@ApiModelProperty("如：smtp.163.com")
	private String host;

	@ApiModelProperty("端口")
	private Integer port;

	@ApiModelProperty("账号")
	private String username;

	@ApiModelProperty("密码")
	private String password;

	@ApiModelProperty("协议")
	private String protocol;

	@ApiModelProperty("默认编码")
	private String defaultEncoding;

	@ApiModelProperty("其他的参数配置(JSON格式)")
	private String properties;

	@ApiModelProperty("创建用户ID")
	private Long createUserId;

	@ApiModelProperty("修改用户ID")
	private Long modifyUserId;

	@ApiModelProperty("创建时间")
	private Date gmtCreate;

	@ApiModelProperty("更改时间")
	private Date gmtModified;

}
