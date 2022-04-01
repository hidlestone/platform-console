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
@ApiModel("用户详细信息响应参数")
public class UserDtlInfoResponse extends BaseEntityResponse {

	@ApiModelProperty("用户昵称")
	private String username;

	@ApiModelProperty("头像URL")
	private String avtar;

	@ApiModelProperty("电话号码")
	private String tel;

	@ApiModelProperty("邮箱")
	private String email;

	@ApiModelProperty("介绍")
	private String introduction;

	@ApiModelProperty("用户角色")
	private List<String> roles;

}
