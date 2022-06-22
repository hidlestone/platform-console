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
@ApiModel("用户登出请求参数")
public class LogoutRequest extends BasePageRequest {

	private static final long serialVersionUID = -469351639513773140L;

	@ApiModelProperty("访问token")
	private String accesstoken;

	@ApiModelProperty("刷新token")
	private String refreshtoken;

}
