package com.wordplay.platform.console;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhuangpf
 */
@SpringBootApplication
@EnableTransactionManagement
public class ConsoleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsoleServiceApplication.class, args);
	}

}

