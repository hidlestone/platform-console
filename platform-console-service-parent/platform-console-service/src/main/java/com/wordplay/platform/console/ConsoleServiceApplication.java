package com.wordplay.platform.console;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhuangpf
 */
@MapperScan(basePackages = {
		"com.fallframework.platform.starter.config.mapper",
		"com.fallframework.platform.starter.i18n.mapper",
		"com.fallframework.platform.starter.mail.mapper",
		"com.fallframework.platform.starter.sms.mapper",
		"com.fallframework.platform.starter.file.mapper",
		"com.fallframework.platform.starter.mq.mapper",
//		"com.fallframework.platform.starter.task.quartz.mapper",
//		"com.fallframework.platform.starter.task.xxljob.mapper",
		"com.fallframework.platform.starter.rbac.mapper",
		"com.fallframework.platform.test.starters.elasticsearch.mapper"
})
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.fallframework", "com.wordplay"})
public class ConsoleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsoleServiceApplication.class, args);
	}

}

