package com.wordplay.platform.console.model.request;

import com.fallframework.platform.starter.api.request.BasePageRequest;
import com.wordplay.platform.console.model.enums.StageEnum;
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
@ApiModel("MQ轨迹日志请求参数")
public class MqTraceLogReq extends BasePageRequest {

	private static final long serialVersionUID = -5439688402841283381L;

	@ApiModelProperty("阶段")
	private StageEnum stage;

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
	private Byte status;

	@ApiModelProperty("开始发布时间")
	private Date startPublishTime;

	@ApiModelProperty("结束发布时间")
	private Date endPublishTime;

	@ApiModelProperty("开始消费时间")
	private Date startConsumeTime;

	@ApiModelProperty("结束消费时间")
	private Date endConsumeTime;

}
