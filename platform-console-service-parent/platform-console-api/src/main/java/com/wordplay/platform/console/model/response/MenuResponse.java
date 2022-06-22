package com.wordplay.platform.console.model.response;

import com.fallframework.platform.starter.api.model.OpenTypeEnum;
import com.fallframework.platform.starter.api.model.StatusEnum;
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
@ApiModel("菜单响应参数")
public class MenuResponse extends BaseEntityResponse {

	private static final long serialVersionUID = 5506960744575988053L;
	@ApiModelProperty("子菜单")
	List<MenuResponse> children;
	@ApiModelProperty(value = "主键")
	private Long id;
	@ApiModelProperty(value = "父级菜单ID")
	private Long parentId;
	@ApiModelProperty(value = "菜单层级")
	private Byte level;
	@ApiModelProperty(value = "菜单编码")
	private String menuCode;
	@ApiModelProperty(value = "菜单名称")
	private String menuName;
	@ApiModelProperty(value = "菜单描述")
	private String menuDesc;
	@ApiModelProperty(value = "访问路径")
	private String path;
	@ApiModelProperty(value = "功能链接如：/platform/msg-log")
	private String funcLink;
	@ApiModelProperty(value = "打开方式，inner-link：通过链接打开tab，outter-link：通过链接打开浏览器新窗口，默认空表示:调用/console/open读取元数据打开")
	private OpenTypeEnum openType;
	@ApiModelProperty(value = "图标")
	private String icon;
	@ApiModelProperty(value = "排序")
	private Byte order;
	@ApiModelProperty(value = "备注")
	private String remark;
	@ApiModelProperty(value = "是否显示")
	private StatusEnum status;

}
