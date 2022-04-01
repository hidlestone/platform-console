package com.wordplay.platform.console.model.response;

import com.fallframework.platform.starter.api.response.BaseEntityResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel("登录成功响应参数")
public class LoginSuccessResponse extends BaseEntityResponse {

	private static final long serialVersionUID = 1700047542342421500L;

	@ApiModelProperty("访问token")
	private String accesstoken;

	@ApiModelProperty("刷新token")
	private String refreshtoken;

	@ApiModelProperty("用户信息")
	private UserResponse curUserInfo;

	@ApiModelProperty("用户角色")
	private List<String> roles;

}
