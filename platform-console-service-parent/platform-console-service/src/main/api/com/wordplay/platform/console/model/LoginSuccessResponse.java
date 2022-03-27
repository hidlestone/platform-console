package com.wordplay.platform.console.model;

import com.fallframework.platform.starter.api.response.BaseEntityResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel(value = "登录成功响应参数")
public class LoginSuccessResponse extends BaseEntityResponse {

	private static final long serialVersionUID = 1700047542342421500L;

	@ApiModelProperty(value = "访问token")
	private String accesstoken;

	@ApiModelProperty(value = "刷新token")
	private String refreshtoken;

}
