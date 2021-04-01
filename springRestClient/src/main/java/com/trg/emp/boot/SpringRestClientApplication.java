package com.trg.emp.boot;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.trg.boot.beans.Employee;

//@SpringBootApplication
public class SpringRestClientApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringRestClientApplication.class, args);

		RestTemplate template = new RestTemplate();
		String baseUrl = "http://localhost:8080/employees/";
		ResponseEntity<List> response1 = template.getForEntity(baseUrl, List.class);

		System.out.println(response1.getBody());
		
		System.out.println(response1.getStatusCode());

		try {
			ResponseEntity<Employee> response = template.getForEntity(baseUrl+"100", Employee.class);
			System.out.println(response.getBody());

		} catch (HttpClientErrorException ex) {
			System.out.println(ex.getRawStatusCode());
		}

		Employee e = new Employee(999, "Ramesh Kumar", 7800);

		ResponseEntity<String> response3 = template.postForEntity(baseUrl, e, String.class);
		
		System.out.println(response3.getBody());
		
	}

}
