package com.trg.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.trg.student"})
public class SpringbootRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestApplication.class, args);
	}

}

