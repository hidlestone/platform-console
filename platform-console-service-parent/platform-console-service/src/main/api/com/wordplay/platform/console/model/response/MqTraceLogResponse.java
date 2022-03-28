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
@ApiModel("MQ轨迹日志响应参数")
public class MqTraceLogResponse extends BaseEntityResponse {

	private static final long serialVersionUID = -2240534832042415665L;

	@ApiModelProperty("主键")
	private Long id;

	@ApiModelProperty("阶段")
	private Boolean stage;

	@ApiModelProperty("消息体JSON")
	private String content;

	@ApiModelProperty("交换机")
	private String exchange;

	@ApiModelProperty("路由")
	private String routeKey;

	@ApiModelProperty("投递TAG")
	private String deliveryTag;

	@ApiModelProperty("消费TAG")
	private String consumerTag;

	@ApiModelProperty("ACK模式")
	private String ackMode;

	@ApiModelProperty("发布时间")
	private Date publishTime;

	@ApiModelProperty("消费时间")
	private Date consumeTime;

	@ApiModelProperty("订阅者")
	private String subscriber;

	@ApiModelProperty("请求ID")
	private Long requestId;

	@ApiModelProperty("状态：0-失败，1-成功")
	private Boolean status;

	@ApiModelProperty("返回码")
	private String replyCode;

	@ApiModelProperty("返回信息")
	private String replyText;

	@ApiModelProperty("创建用户ID")
	private Long createUserId;

	@ApiModelProperty("修改用户ID")
	private Long modifyUserId;

	@ApiModelProperty("创建时间")
	private Date gmtCreate;

	@ApiModelProperty("更改时间")
	private Date gmtModified;
	
}
