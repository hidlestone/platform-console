package com.wordplay.platform.console.model.request;

import com.fallframework.platform.starter.api.model.StatusEnum;
import com.fallframework.platform.starter.api.request.BasePageRequest;
import com.wordplay.platform.console.model.enums.FileTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel("文件明细项请求参数")
public class FileInfoReq extends BasePageRequest {

	private static final long serialVersionUID = -2336125469947087327L;

	@ApiModelProperty("主键")
	private Long id;

	@ApiModelProperty("文件组ID")
	private Long fileGroupId;

	@ApiModelProperty("文件名")
	private String name;

	@ApiModelProperty("无意义名称")
	private String nonsenseName;

	@ApiModelProperty("文件扩展名")
	private String extension;

	@ApiModelProperty("存储类型")
	private Byte storageType;

	@ApiModelProperty("文件类型")
	private FileTypeEnum fileType;

	@ApiModelProperty("contentType")
	private String contentType;

	@ApiModelProperty("备注")
	private String remark;

	@ApiModelProperty("文件url")
	private String url;

	@ApiModelProperty("文件业务类型")
	private String category;

	@ApiModelProperty("文件状态")
	private StatusEnum status;

}
