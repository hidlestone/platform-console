package com.wordplay.platform.console;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhuangpf
 */
@EnableDiscoveryClient
@EnableFeignClients(
		basePackages = {"com.wordplay.platform.console.client.api"}
)
@MapperScan(basePackages = {
		"com.fallframework.platform.starter.config.mapper",
		"com.fallframework.platform.starter.i18n.mapper",
		"com.fallframework.platform.starter.mail.mapper",
		"com.fallframework.platform.starter.sms.mapper",
		"com.fallframework.platform.starter.file.mapper",
		"com.fallframework.platform.starter.mq.mapper",
		"com.fallframework.platform.starter.rbac.mapper",
})
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.fallframework", "com.wordplay"})
public class ConsoleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsoleServiceApplication.class, args);
	}

}

