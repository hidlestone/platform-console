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
@ApiModel("短信历史请求参数")
public class SmsHistoryRequest extends BasePageRequest {

	private static final long serialVersionUID = 4745709034024473849L;

	@ApiModelProperty("主键")
	private Long id;

	@ApiModelProperty("短信模板ID")
	private Long templateId;

	@ApiModelProperty("邮件配置ID")
	private Long configId;

	@ApiModelProperty("发送者")
	private String from;

	@ApiModelProperty("接收用户ID")
	private Long receiveUserId;

	@ApiModelProperty("接收用户名称")
	private String receiveUserName;

	@ApiModelProperty("接收号码")
	private String receivePhoneNumber;

	@ApiModelProperty("内容")
	private String content;

	@ApiModelProperty("文件组ID")
	private Long fileGroupId;

	@ApiModelProperty("发送次数")
	private Byte tryCount;

	@ApiModelProperty("失败原因")
	private String msg;

	@ApiModelProperty("最后一次发送时间")
	private Date lastSendTime;

	@ApiModelProperty(" 0-失败，1-成功")
	private StatusEnum status;

	@ApiModelProperty("最后一次发送时间")
	private Date startLastSendTime;

	@ApiModelProperty("最后一次发送时间")
	private Date endLastSendTime;

}
