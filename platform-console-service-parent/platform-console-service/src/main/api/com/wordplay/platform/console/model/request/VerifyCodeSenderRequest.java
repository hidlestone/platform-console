package com.wordplay.platform.console.model.request;

import com.fallframework.platform.starter.api.request.BaseEntityRequest;
import com.wordplay.platform.console.model.enums.VerifyCodeSenderEnum;
import com.wordplay.platform.console.model.enums.VerifyCodeTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel("发送验证码请求参数")
public class VerifyCodeSenderRequest extends BaseEntityRequest {

	private static final long serialVersionUID = -6649061046684818697L;

	@ApiModelProperty("验证码类型")
	private VerifyCodeTypeEnum verifyCodeType;

	@ApiModelProperty("验证码发送方式")
	private VerifyCodeSenderEnum verifyCodeSender;

	@ApiModelProperty("手机号码")
	private String tel;

	@ApiModelProperty("邮箱地址")
	private String mailAddress;

}
