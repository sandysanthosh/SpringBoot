package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
@EnableScheduling
public class DemogApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemogApplication.class, args);
	}

}
