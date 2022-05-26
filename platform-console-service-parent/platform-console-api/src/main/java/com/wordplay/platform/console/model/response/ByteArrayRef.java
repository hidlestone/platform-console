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
@ApiModel("用户其他信息")
public class ByteArrayRef implements Serializable {

	private static final long serialVersionUID = 6857790523810895029L;

	@ApiModelProperty("ID")
	private String id;

	@ApiModelProperty("名称")
	private String name;

	@ApiModelProperty("firstName")
	private ByteArrayEntity entity;

}
