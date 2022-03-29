package com.wordplay.platform.console;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 API接口文档配置
 * <p>
 * http://localhost:6060/doc.html#/home
 *
 * @author zhuangpf
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
public class ConsoleServiceKnife4jConfig {

	@Bean(value = "consoleserviceapi")
	public Docket sourceClientApi() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(new ApiInfoBuilder()
				.title("platform-console-service APIs")
				.description("platform-console接口文档")
				.termsOfServiceUrl("http://localhost:6060/")
				.version("1.0-SNAPSHOT").build())
				// 分组名称
				.groupName("CONSOLE-SERVICE").select()
				// 指定client扫描包路径
				.apis(RequestHandlerSelectors.basePackage("com.wordplay.platform.console.client.impl"))
				.paths(PathSelectors.any()).build();
		return docket;
	}

}
