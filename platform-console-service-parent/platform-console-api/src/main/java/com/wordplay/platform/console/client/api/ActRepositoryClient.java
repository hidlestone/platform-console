package com.wordplay.platform.console.client.api;

import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.model.request.ModelQueryRequest;
import com.wordplay.platform.console.model.request.ProcessDefinitionQueryRequest;
import com.wordplay.platform.console.model.request.StartProcessResponse;
import com.wordplay.platform.console.model.response.ModelResponse;
import com.wordplay.platform.console.model.response.ProcessDefinitionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhuangpf
 */
@FeignClient(name = "${platform.console.service.name}${platform.console.service.version:}/${platform.console.service.version}/actrepository")
public interface ActRepositoryClient {

	/**
	 * 根据输入流部署流程
	 *
	 * @param resourceName 名称
	 * @param inputStream  输入流
	 * @return 是否部署成功
	 */
	@GetMapping("/deploybyinputstream")
	ResponseResult deployByInputStream(@RequestParam String resourceName, @RequestParam InputStream inputStream);

	/**
	 * 根据跟路径下文件部署流程
	 *
	 * @param resource 文件名
	 * @return 是否部署成功
	 */
	@GetMapping("/deploybyclasspathresource")
	ResponseResult deployByClasspathResource(@RequestParam String resource);

	/**
	 * 根据字符串部署流程
	 *
	 * @param resourceName 名称
	 * @param str          流程定义字符串
	 * @return 是否部署成功
	 */
	@GetMapping("/deploybystring")
	ResponseResult deployByString(@RequestParam String resourceName, @RequestParam String str);

	/**
	 * 根据zip输入流部署流程
	 *
	 * @param zipInputStream 输入流
	 * @return 是否部署成功
	 */
//	@PostMapping("/deployByZipInputStream")
//	ResponseResult deployByZipInputStream(ZipInputStream zipInputStream);

	/**
	 * 根据BpmnModel部署流程
	 *
	 * @param resourceName 名称
	 * @param bpmnModel    model
	 * @return 是否部署成功
	 */
//	@GetMapping("/deploybystring")
//	ResponseResult deployByBpmnModel(String resourceName, BpmnModel bpmnModel);

	/**
	 * 根据名称发布流程
	 *
	 * @param bpmnName 流程名称
	 * @return 是否部署成功
	 */
	@GetMapping("/deploybybpmnname")
	ResponseResult deployByBpmnName(@RequestParam String bpmnName);

	/**
	 * 删除(已部署)流程定义
	 *
	 * @param deploymentId 部署ID
	 * @return 是否删除成功
	 */
	@GetMapping("/deleteDeployment")
	ResponseResult deleteDeployment(@RequestParam String deploymentId);

	/**
	 * 分页查询((模型)已部署)流程定义列表
	 *
	 * @param request 请求参数
	 * @return 流程定义分页
	 */
	@PostMapping("/getprocessdefinitionlist")
	ResponseResult<Leaf<ProcessDefinitionResponse>> getProcessDefinitionList(@RequestBody ProcessDefinitionQueryRequest request);

	/**
	 * 下载资源文件
	 *
	 * @param definitionKey 流程定义key
	 * @return 文件
	 */
	@GetMapping("/downloadbpmnile")
	ResponseResult downloadBpmnile(@RequestParam String definitionKey);

	/**
	 * 分页查询模型列表
	 *
	 * @param request 请求参数
	 * @return 模型分页
	 */
	@PostMapping("/downloadbpmnile")
	ResponseResult<Leaf<ModelResponse>> getModelList(@RequestBody ModelQueryRequest request);

	/**
	 * 根据已设计好的模型进行部署
	 *
	 * @param modelId 模型ID
	 * @return 是否部署成功
	 */
	@GetMapping("/deploybymodelid")
	ResponseResult deployByModelId(@RequestParam String modelId) throws IOException;

	/**
	 * 跳转到流程开启页(如果有的话)携带的数据
	 *
	 * @param procDefId 流程定义ID
	 * @return 开启流程所需信息
	 */
	@GetMapping("/startprocessinfo")
	ResponseResult<StartProcessResponse> startProcessInfo(@RequestParam String procDefId);

	/**
	 * 删除流程实例（未部署model）
	 *
	 * @param modelId 模型ID
	 * @return 是否删除成功
	 */
	@GetMapping("/deletemodel")
	ResponseResult deleteModel(@RequestParam String modelId);

}
