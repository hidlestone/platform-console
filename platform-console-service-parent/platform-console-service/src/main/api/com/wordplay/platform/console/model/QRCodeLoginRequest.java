package com.wordplay.platform.console.model;

import com.fallframework.platform.starter.api.request.BaseEntityRequest;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel(value = "二维码登录请求参数")
public class QRCodeLoginRequest extends BaseEntityRequest {

	private static final long serialVersionUID = 2510190274651128509L;
	
	
	
}
