package com.wordplay.platform.console.model.response;

import com.fallframework.platform.starter.api.response.BaseEntityResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel("文件组响应参数")
public class FileGroupResponse extends BaseEntityResponse {

	private static final long serialVersionUID = -7980093753360873758L;

	@ApiModelProperty("主键")
	private Long id;

	@ApiModelProperty("描述")
	private String desc;

	@ApiModelProperty("文件组状态")
	private Boolean status;

	@ApiModelProperty("创建用户ID")
	private Long createUserId;

	@ApiModelProperty("修改用户ID")
	private Long modifyUserId;

	@ApiModelProperty("创建时间")
	private Date gmtCreate;

	@ApiModelProperty("更改时间")
	private Date gmtModified;

	@ApiModelProperty("文件明细项")
	private List<FileInfoResponse> fileInfoResponseList;
}
