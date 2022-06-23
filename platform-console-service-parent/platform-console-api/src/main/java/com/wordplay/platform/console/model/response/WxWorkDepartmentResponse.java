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
@ApiModel("企微部门")
public class WxWorkDepartmentResponse extends BaseEntityResponse {

	private static final long serialVersionUID = -4604844209798299466L;

	@ApiModelProperty("ID")
	private Long id;

	@ApiModelProperty("部门名称")
	private String name;

	@ApiModelProperty("部门英文名称")
	private String nameEn;

	@ApiModelProperty("部门负责人的UserID；第三方仅通讯录应用可获取")
	private String departmentLeader;

	@ApiModelProperty("	父部门id。根部门为1")
	private Long parentId;

	@ApiModelProperty("在父部门中的次序值。order值大的排序靠前。值范围是[0, 2^32)")
	private Long order;

}
