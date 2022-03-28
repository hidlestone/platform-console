package com.wordplay.platform.console;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhuangpf
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(
		basePackages = {"com.wordplay.platform.console.client.api"}
)
@ComponentScan(basePackages = {"com.fallframework", "com.wordplay"})
public class ConsoleControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsoleControlApplication.class, args);
	}

}

