package com.wordplay.platform.console.model.response;

import com.fallframework.platform.starter.api.response.BaseEntityResponse;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel("接口权限响应参数")
public class ModelResponse extends BaseEntityResponse {

	private static final long serialVersionUID = -1975177040843764705L;

	private String name;
	private String key;
	private String category;
	private Date createTime;
	private Date lastUpdateTime;
	private Integer version = 1;
	private String metaInfo;
	private String deploymentId;
	private String editorSourceValueId;
	private String editorSourceExtraValueId;
	private String tenantId = "";

}
