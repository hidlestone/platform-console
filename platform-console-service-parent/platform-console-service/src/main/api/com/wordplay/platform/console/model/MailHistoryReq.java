package com.wordplay.platform.console.model;

import com.fallframework.platform.starter.api.model.StatusEnum;
import com.fallframework.platform.starter.api.request.BasePageRequest;
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
@ApiModel(value = "邮件历史请求参数")
public class MailHistoryReq extends BasePageRequest {

	private static final long serialVersionUID = -2169210238876831711L;

	@ApiModelProperty(value = "邮件模板ID")
	private Long templateId;

	@ApiModelProperty(value = "邮件配置ID")
	private Long configId;

	@ApiModelProperty(value = "标题")
	private String title;

	@ApiModelProperty(value = "发送者")
	private String from;

	@ApiModelProperty(value = "接收用户ID")
	private Long receiveUserId;

	@ApiModelProperty(value = "接收用户名称")
	private Long receiveUserName;

	@ApiModelProperty(value = "接收邮箱")
	private String receiveMail;

	@ApiModelProperty(value = "抄送者")
	private String cc;

	@ApiModelProperty(value = "密送者")
	private String bcc;

	@ApiModelProperty(value = "内容")
	private String content;

	@ApiModelProperty(value = "文件组ID")
	private Long fileGroupId;

	@ApiModelProperty(value = "发送次数")
	private Integer tryCount;

	@ApiModelProperty(value = "失败原因")
	private Byte msg;

	@ApiModelProperty(value = "最后一次发送时间")
	private Date lastSendTime;

	@ApiModelProperty(value = "0-失败，1-成功")
	private StatusEnum sendFlag;

}
