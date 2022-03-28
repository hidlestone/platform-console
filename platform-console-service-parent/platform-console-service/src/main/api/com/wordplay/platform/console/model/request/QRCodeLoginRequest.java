package com.wordplay.platform.console.model.request;

import com.fallframework.platform.starter.api.request.BaseEntityRequest;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel("二维码登录请求参数")
public class QRCodeLoginRequest extends BaseEntityRequest {

	private static final long serialVersionUID = 2510190274651128509L;
	
}
