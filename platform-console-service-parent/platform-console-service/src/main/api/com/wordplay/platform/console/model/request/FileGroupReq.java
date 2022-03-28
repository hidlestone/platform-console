package com.wordplay.platform.console.model.request;

import com.fallframework.platform.starter.api.model.StatusEnum;
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
@ApiModel("文件组请求参数")
public class FileGroupReq extends BasePageRequest {

	private static final long serialVersionUID = -2465784424791444246L;

	@ApiModelProperty("主键")
	private Long id;

	@ApiModelProperty("描述")
	private String desc;

	@ApiModelProperty("文件组状态")
	private StatusEnum status;

	@ApiModelProperty("文件明细项请求参数")
	private List<FileInfoReq> fileInfoList;

}
