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
@ApiModel("企微通讯录同步日志")
public class WxWorkSyncLogRequest extends BasePageRequest {

	private static final long serialVersionUID = 1917182047700111919L;

	/**
	 * 主键
	 */
	@ApiModelProperty("主键")
	private Long id;

	/**
	 * 所属配置id
	 */
	@ApiModelProperty("所属配置id")
	private Long configId;

	/**
	 * 同步结果编码
	 */
	@ApiModelProperty("同步结果编码")
	private String errcode;

	/**
	 * 同步结果信息
	 */
	@ApiModelProperty("同步结果信息")
	private String errmsg;

}
