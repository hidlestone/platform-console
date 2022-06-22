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
@ApiModel("接口权限响应参数")
public class PermissionResponse extends BaseEntityResponse {

	private static final long serialVersionUID = 4296092743328100164L;

	@ApiModelProperty("主键")
	private Long id;

	@ApiModelProperty("权限编码")
	private String permissionCode;

	@ApiModelProperty("权限名称即接口名称")
	private String permissionName;

	@ApiModelProperty("资源值即URL")
	private String resourceValue;

	@ApiModelProperty("顺序")
	private Integer orderNum;

	@ApiModelProperty("认证类型：anon(允许匿名访问)，auth(登录即可访问)")
	private Boolean authcType;

	@ApiModelProperty("创建用户ID")
	private Long createUserId;

	@ApiModelProperty("修改用户ID")
	private Long modifyUserId;

	@ApiModelProperty("创建时间")
	private Date gmtCreate;

	@ApiModelProperty("更改时间")
	private Date gmtModified;

}
