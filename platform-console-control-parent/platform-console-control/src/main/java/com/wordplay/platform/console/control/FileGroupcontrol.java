package com.wordplay.platform.console.control;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuangpf
 */
@Api(tags = "文件组管理")
@RestController
@RequestMapping("/filegroup")
public class FileGroupcontrol {

	private FileGroupClient fileGroupClient; 
	

}
