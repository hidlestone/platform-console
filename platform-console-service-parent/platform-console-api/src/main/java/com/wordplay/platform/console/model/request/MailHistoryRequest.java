package com.wordplay.platform.console.model.request;

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
@ApiModel("邮件历史请求参数")
public class MailHistoryRequest extends BasePageRequest {

	private static final long serialVersionUID = -2169210238876831711L;

	@ApiModelProperty("邮件模板ID")
	private Long templateId;

	@ApiModelProperty("邮件配置ID")
	private Long configId;

	@ApiModelProperty("标题")
	private String title;

	@ApiModelProperty("发送者")
	private String from;

	@ApiModelProperty("接收用户ID")
	private Long receiveUserId;

	@ApiModelProperty("接收用户名称")
	private Long receiveUserName;

	@ApiModelProperty("接收邮箱")
	private String receiveMail;

	@ApiModelProperty("抄送者")
	private String cc;

	@ApiModelProperty("密送者")
	private String bcc;

	@ApiModelProperty("内容")
	private String content;

	@ApiModelProperty("文件组ID")
	private Long fileGroupId;

	@ApiModelProperty("发送次数")
	private Integer tryCount;

	@ApiModelProperty("失败原因")
	private String msg;

	@ApiModelProperty("最后一次发送时间")
	private Date lastSendTime;

	@ApiModelProperty("0-失败，1-成功")
	private StatusEnum sendFlag;

}
