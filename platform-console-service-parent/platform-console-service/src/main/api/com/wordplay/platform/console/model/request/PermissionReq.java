package com.wordplay.platform.console.model.request;

import com.fallframework.platform.starter.api.request.BasePageRequest;
import com.wordplay.platform.console.model.enums.AuthcTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel("权限查询请求参数")
public class PermissionReq extends BasePageRequest {

	private static final long serialVersionUID = 8949192605311863780L;

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
	private AuthcTypeEnum authcType;

}
