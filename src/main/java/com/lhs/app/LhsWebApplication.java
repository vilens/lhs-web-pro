package com.lhs.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.lhs.*")
@SpringBootApplication
public class LhsWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(LhsWebApplication.class, args)
				.registerShutdownHook();
	}
}
