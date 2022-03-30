package com.wordplay.platform.console.model.request;

import com.fallframework.platform.starter.api.request.BaseEntityRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author zhuangpf
 */
@Getter
@Setter
@ApiModel("文件上传请求参数")
public class FileGroupUploadReq extends BaseEntityRequest {

	private static final long serialVersionUID = -355449103197876043L;

	@ApiModelProperty("描述")
	private String desc;

	@ApiModelProperty("存储类型")
	private Byte storageType;

	@ApiModelProperty("请求上传的文件")
	private List<MultipartFile> files;

}
