package com.wordplay.platform.console.model.response;

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
@ApiModel("企微部门成员")
public class WxWorkUserResponse extends BasePageRequest {

	private static final long serialVersionUID = -3058297566830026274L;

	/**
	 * 成员userid
	 */
	@ApiModelProperty("成员userid")
	private String userid;

	/**
	 * 成员名称
	 */
	@ApiModelProperty("成员名称")
	private String name;

	/**
	 * 职务信息
	 */
	@ApiModelProperty("职务信息")
	private String position;

	/**
	 * 手机号码
	 */
	@ApiModelProperty("手机号码")
	private String mobile;

	/**
	 * 性别
	 */
	@ApiModelProperty("性别")
	private String gender;

	/**
	 * 邮箱
	 */
	@ApiModelProperty("邮箱")
	private String email;

	/**
	 * 企业邮箱
	 */
	@ApiModelProperty("企业邮箱")
	private String bizMail;

	/**
	 * 头像url
	 */
	@ApiModelProperty("头像url")
	private String avatar;

	/**
	 * 头像缩略图url
	 */
	@ApiModelProperty("头像缩略图url")
	private String thumbAvatar;

	/**
	 * 座机
	 */
	@ApiModelProperty("座机")
	private String telephone;

	/**
	 * 别名
	 */
	@ApiModelProperty("别名")
	private String alias;

	/**
	 * 地址
	 */
	@ApiModelProperty("地址")
	private String address;

	/**
	 * 全局唯一
	 */
	@ApiModelProperty("全局唯一")
	private String openUserid;

	/**
	 * 主部门
	 */
	@ApiModelProperty("主部门")
	private Long mainDepartment;

	/**
	 * 扩展属性
	 */
	@ApiModelProperty("扩展属性")
	private String extattr;

	/**
	 * 激活状态
	 */
	@ApiModelProperty("激活状态")
	private Byte status;

	/**
	 * 员工个人二维码
	 */
	@ApiModelProperty("员工个人二维码")
	private String qrCode;

	/**
	 * 对外职务
	 */
	@ApiModelProperty("对外职务")
	private String externalPosition;

	/**
	 * 成员对外属性
	 */
	@ApiModelProperty("成员对外属性")
	private String externalProfile;

}
