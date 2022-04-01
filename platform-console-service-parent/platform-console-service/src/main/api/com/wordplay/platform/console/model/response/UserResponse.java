package com.wordplay.platform.console.model.response;

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
@ApiModel("用户信息响应参数")
public class UserResponse extends BaseEntityResponse {

	private static final long serialVersionUID = 8958948271004116164L;

	@ApiModelProperty("用户昵称")
	private String username;

	@ApiModelProperty("头像URL")
	private String avatar;

	@ApiModelProperty("电话号码")
	private String tel;

	@ApiModelProperty("邮箱")
	private String email;

	@ApiModelProperty("介绍")
	private String introduction;

}
