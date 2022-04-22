package com.wordplay.platform.console.model.response;

import com.fallframework.platform.starter.api.model.StatusEnum;
import com.fallframework.platform.starter.api.response.BaseEntityResponse;
import com.fallframework.platform.starter.rbac.model.OpenTypeEnum;
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
@ApiModel("菜单响应参数")
public class MenuResponse extends BaseEntityResponse {

	private static final long serialVersionUID = 5506960744575988053L;

	@ApiModelProperty("主键")
	private Long id;

	@ApiModelProperty("父级菜单ID")
	private Long parentId;

	@ApiModelProperty("菜单编码")
	private String menuCode;

	@ApiModelProperty("菜单名称")
	private String menuName;

	@ApiModelProperty("菜单描述")
	private String menuDesc;

	@ApiModelProperty("访问路径")
	private String path;

	@ApiModelProperty("功能链接如：/platform/msg-log")
	private String funcLink;

	@ApiModelProperty("打开方式，inner-link：通过链接打开tab，outter-link：通过链接打开浏览器新窗口，默认空表示")
	private OpenTypeEnum openType;

	@ApiModelProperty("图标")
	private String icon;

	@ApiModelProperty("排序")
	private Byte order;

	@ApiModelProperty("备注")
	private String remark;

	@ApiModelProperty("是否显示")
	private StatusEnum status;

	@ApiModelProperty("创建用户ID")
	private Long createUserId;

	@ApiModelProperty("修改用户ID")
	private Long modifyUserId;

	@ApiModelProperty("创建时间")
	private Date gmtCreate;

	@ApiModelProperty("更改时间")
	private Date gmtModified;

}
