package com.adrianaden.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@ComponentScan("com.adrianaden.app")
public class AppApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	
}
