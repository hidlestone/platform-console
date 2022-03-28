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
@ApiModel("用户信息响应参数")
public class UserResponse extends BaseEntityResponse {

	private static final long serialVersionUID = 8958948271004116164L;

	@ApiModelProperty("主键")
	private Long id;

	@ApiModelProperty("用户账号")
	private String account;

	@ApiModelProperty("用户昵称")
	private String username;

	@ApiModelProperty("头像URL")
	private String avtar;

	@ApiModelProperty("电话号码")
	private String tel;

	@ApiModelProperty("邮箱")
	private String email;

	@ApiModelProperty("身份证号")
	private String idCard;

	@ApiModelProperty("真实姓名")
	private String name;

	@ApiModelProperty("生日")
	private Date birthday;

	@ApiModelProperty("地址")
	private String address;

	@ApiModelProperty("性别")
	private Byte sex;

	@ApiModelProperty("状态")
	private Byte status;

	@ApiModelProperty("备注")
	private String remark;

	@ApiModelProperty("用户来源")
	private Byte sourceType;

	@ApiModelProperty("最后登录时间")
	private Date lastLoginTime;

	@ApiModelProperty("创建用户ID")
	private Long createUserId;

	@ApiModelProperty("修改用户ID")
	private Long modifyUserId;

	@ApiModelProperty("创建时间")
	private Date gmtCreate;

	@ApiModelProperty("更改时间")
	private Date gmtModified;

}
