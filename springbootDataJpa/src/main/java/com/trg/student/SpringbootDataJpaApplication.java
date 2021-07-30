package com.trg.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.jpa")
@EnableSwagger2
public class SpringbootDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataJpaApplication.class, args);
	}
}
