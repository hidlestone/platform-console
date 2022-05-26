package com.wordplay.platform.console.model.response;

import com.fallframework.platform.starter.api.request.BasePageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * activiti 用户组
 *
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel("用户组请求参数")
public class ActGroupResponse extends BasePageRequest {

	private static final long serialVersionUID = -6255188883899698790L;
	
	@ApiModelProperty("用户组名称")
	private String name;

	@ApiModelProperty("用户组类型")
	private String type;

}
