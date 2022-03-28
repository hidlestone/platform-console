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
@ApiModel("短信模板响应参数")
public class SmsTemplateResponse extends BaseEntityResponse {

	private static final long serialVersionUID = -1931832780076361961L;

	@ApiModelProperty("主键")
	private Long id;

	@ApiModelProperty("短信模板配置描述")
	private String desc;

	@ApiModelProperty("发送号码")
	private String from;

	@ApiModelProperty("0-简单，1-模板")
	private Boolean contentType;

	@ApiModelProperty("内容")
	private String content;

	@ApiModelProperty("文件组ID")
	private Long fileGroupId;

	@ApiModelProperty("重试次数")
	private Boolean retryCount;

	@ApiModelProperty("创建用户ID")
	private Long createUserId;

	@ApiModelProperty("修改用户ID")
	private Long modifyUserId;

	@ApiModelProperty("创建时间")
	private Date gmtCreate;

	@ApiModelProperty("更改时间")
	private Date gmtModified;
	
}
