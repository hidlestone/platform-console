package com.wordplay.platform.console.model.response;

import com.fallframework.platform.starter.api.response.BaseEntityResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel("文件明细项响应参数")
public class FileInfoResponse extends BaseEntityResponse {

	private static final long serialVersionUID = -9115862325100666288L;

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

	@ApiModelProperty("文件类型")
	private Boolean fileType;

	@ApiModelProperty("存储类型")
	private Boolean storageType;

	@ApiModelProperty("contentType")
	private String contentType;

	@ApiModelProperty("备注")
	private String remark;

	@ApiModelProperty("文件url")
	private String url;

	@ApiModelProperty("文件业务类型")
	private String category;

	@ApiModelProperty("文件状态")
	private Boolean status;

	@ApiModelProperty("创建用户ID")
	private Long createUserId;

	@ApiModelProperty("修改用户ID")
	private Long modifyUserId;

	@ApiModelProperty("创建时间")
	private Date gmtCreate;

	@ApiModelProperty("更改时间")
	private Date gmtModified;

}
