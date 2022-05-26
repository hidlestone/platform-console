package com.wordplay.platform.console.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel("字节数组信息")
public class ByteArrayEntity implements Serializable {

	private static final long serialVersionUID = 2012469139504316431L;

	@ApiModelProperty("名称")
	protected String name;

	@ApiModelProperty("字节数组")
	protected byte[] bytes;

	@ApiModelProperty("部署ID")
	protected String deploymentId;

}
