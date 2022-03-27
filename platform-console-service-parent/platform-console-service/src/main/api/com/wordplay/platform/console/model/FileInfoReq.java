package com.wordplay.platform.console.model;

import com.fallframework.platform.starter.api.model.StatusEnum;
import com.fallframework.platform.starter.api.request.BasePageRequest;
import com.fallframework.platform.starter.file.model.FileTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel(value = "文件明细项请求参数")
public class FileInfoReq extends BasePageRequest {

	private static final long serialVersionUID = -2336125469947087327L;

	@ApiModelProperty(value = "主键")
	private Long id;

	@ApiModelProperty(value = "文件组ID")
	private Long fileGroupId;

	@ApiModelProperty(value = "文件名")
	private String name;

	@ApiModelProperty(value = "无意义名称")
	private String nonsenseName;

	@ApiModelProperty(value = "文件扩展名")
	private String extension;

	@ApiModelProperty(value = "存储类型")
	private Byte storageType;

	@ApiModelProperty(value = "文件类型")
	private FileTypeEnum fileType;

	@ApiModelProperty(value = "contentType")
	private String contentType;

	@ApiModelProperty(value = "备注")
	private String remark;

	@ApiModelProperty(value = "文件url")
	private String url;

	@ApiModelProperty(value = "文件业务类型")
	private String category;

	@ApiModelProperty(value = "文件状态")
	private StatusEnum status;

}
