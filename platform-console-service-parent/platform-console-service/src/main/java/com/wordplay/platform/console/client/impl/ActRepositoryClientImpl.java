package com.wordplay.platform.console.client.impl;

import com.alibaba.fastjson.JSON;
import com.fallframework.platform.starter.activiti.model.ModelQueryDto;
import com.fallframework.platform.starter.activiti.model.ProcessDefinitionQueryDto;
import com.fallframework.platform.starter.activiti.model.StartProcessOutVo;
import com.fallframework.platform.starter.activiti.service.ActRepositoryService;
import com.fallframework.platform.starter.api.model.Leaf;
import com.fallframework.platform.starter.api.response.ResponseResult;
import com.wordplay.platform.console.client.api.ActRepositoryClient;
import com.wordplay.platform.console.model.request.ModelQueryRequest;
import com.wordplay.platform.console.model.request.ProcessDefinitionQueryRequest;
import com.wordplay.platform.console.model.request.StartProcessResponse;
import com.wordplay.platform.console.model.response.ModelResponse;
import com.wordplay.platform.console.model.response.ProcessDefinitionResponse;
import com.wordplay.platform.console.util.LeafPageUtil;
import io.swagger.annotations.ApiOperation;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhuangpf
 */
public class ActRepositoryClientImpl implements ActRepositoryClient {

	@Autowired
	private ActRepositoryService actRepositoryService;

	@Override
	@PostMapping("/deploybyinputstream")
	@ApiOperation("根据输入流部署流程")
	public ResponseResult deployByInputStream(@RequestParam String resourceName, @RequestParam InputStream inputStream) {
		return actRepositoryService.deployByInputStream(resourceName, inputStream);
	}

	@Override
	@GetMapping("/deploybyclasspathresource")
	@ApiOperation("根据跟路径下文件部署流程")
	public ResponseResult deployByClasspathResource(@RequestParam String resource) {
		return actRepositoryService.deployByClasspathResource(resource);
	}

	@Override
	@GetMapping("/deploybystring")
	@ApiOperation("根据字符串部署流程")
	public ResponseResult deployByString(@RequestParam String resourceName, @RequestParam String str) {
		return actRepositoryService.deployByString(resourceName, str);
	}

	@Override
	@GetMapping("/deploybybpmnname")
	@ApiOperation("根据名称发布流程")
	public ResponseResult deployByBpmnName(@RequestParam String bpmnName) {
		return actRepositoryService.deployByBpmnName(bpmnName);
	}

	@Override
	@GetMapping("/deletedeployment")
	@ApiOperation("删除(已部署)流程定义")
	public ResponseResult deleteDeployment(@RequestParam String deploymentId) {
		return actRepositoryService.deleteDeployment(deploymentId);
	}

	@Override
	@PostMapping("/getprocessdefinitionlist")
	@ApiOperation("删除(已部署)流程定义")
	public ResponseResult<Leaf<ProcessDefinitionResponse>> getProcessDefinitionList(@RequestBody ProcessDefinitionQueryRequest request) {
		ProcessDefinitionQueryDto dto = new ProcessDefinitionQueryDto();
		BeanUtils.copyProperties(request, dto);
		Leaf<ProcessDefinition> page = actRepositoryService.getProcessDefinitionList(dto).getData();
		Leaf leaf = LeafPageUtil.leafToType(page, ProcessDefinitionResponse.class);
		return ResponseResult.success(leaf);
	}

	@Override
	@GetMapping("/downloadbpmnile")
	@ApiOperation("下载资源文件")
	public ResponseResult downloadBpmnile(@RequestParam String definitionKey) {
		return actRepositoryService.downloadBpmnile(definitionKey);
	}

	@Override
	@PostMapping("/getmodellist")
	@ApiOperation("分页查询模型列表")
	public ResponseResult<Leaf<ModelResponse>> getModelList(@RequestBody ModelQueryRequest request) {
		ModelQueryDto dto = new ModelQueryDto();
		BeanUtils.copyProperties(request, dto);
		Leaf<Model> page = actRepositoryService.getModelList(dto).getData();
		Leaf leaf = LeafPageUtil.leafToType(page, ModelResponse.class);
		return ResponseResult.success(leaf);
	}

	@Override
	@GetMapping("/deploybymodelid")
	@ApiOperation("根据已设计好的模型进行部署")
	public ResponseResult deployByModelId(@RequestParam String modelId) throws IOException {
		return actRepositoryService.deployByModelId(modelId);
	}

	@Override
	@GetMapping("/startprocessinfo")
	@ApiOperation("跳转到流程开启页(如果有的话)携带的数据")
	public ResponseResult<StartProcessResponse> startProcessInfo(@RequestParam String procDefId) {
		StartProcessOutVo outVo = actRepositoryService.startProcessInfo(procDefId).getData();
		StartProcessResponse startProcessResponse = JSON.parseObject(JSON.toJSONString(outVo), StartProcessResponse.class);
		return ResponseResult.success(startProcessResponse);
	}

	@Override
	@GetMapping("/deletemodel")
	@ApiOperation("删除流程实例（未部署model）")
	public ResponseResult deleteModel(@RequestParam String modelId) {
		return actRepositoryService.deleteModel(modelId);
	}

}
