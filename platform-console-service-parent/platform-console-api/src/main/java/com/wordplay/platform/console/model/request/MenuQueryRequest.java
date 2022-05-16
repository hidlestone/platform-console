package com.wordplay.platform.console.model.request;

import com.fallframework.platform.starter.api.request.BasePageRequest;
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
@ApiModel("菜单查询请求参数")
public class MenuQueryRequest extends BasePageRequest {

	private static final long serialVersionUID = -1176042930719311116L;

	@ApiModelProperty("用户ID")
	private Long userId;

	@ApiModelProperty("角色ID")
	private List<Long> roleIds;

}
