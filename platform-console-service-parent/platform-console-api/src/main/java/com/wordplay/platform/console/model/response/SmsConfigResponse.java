package com.wordplay.platform.console.model.response;

import com.fallframework.platform.starter.api.response.BaseEntityResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@ApiModel("短信配置响应参数")
public class SmsConfigResponse extends BaseEntityResponse {

	private static final long serialVersionUID = 7366443188115175063L;

	@ApiModelProperty("主键")
	private Long id;

	@ApiModelProperty("使用的短信产品类型")
	private String productType;

	@ApiModelProperty("区域ID")
	private String regionId;

	@ApiModelProperty("accessKeyId")
	private String accessKeyId;

	@ApiModelProperty("accessKeySecret")
	private String accessKeySecret;

	@ApiModelProperty("其他的参数配置(JSON格式)")
	private String properties;

	@ApiModelProperty("创建用户ID")
	private Long createUserId;

	@ApiModelProperty("修改用户ID")
	private Long modifyUserId;

	@ApiModelProperty("创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date gmtCreate;

	@ApiModelProperty("更改时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date gmtModified;

}
