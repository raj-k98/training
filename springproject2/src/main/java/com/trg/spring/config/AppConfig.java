package com.trg.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.trg.spring.beans.Address;
import com.trg.spring.beans.Employee;

@Configuration
public class AppConfig {
	
	@Bean(name = "address1")
	public Address getAddress1() {
		Address add = new Address();
		add.setStreet("GB Street");
		add.setCity("New Delhi");
		add.setPinCode(110001);
		return add;
	}
	
	
	@Bean(name = "address2")
	public Address getAddress2() {
		Address add = new Address();
		add.setStreet("Shastri Street");
		add.setCity("Hyderabad");
		add.setPinCode(500045);
		return add;
	}
	
	@Bean(name="emp1")
	@Scope("prototype")
	public Employee getEmployee1() {
		
		Employee e = new Employee();
		e.setEmpId(100);
		e.setName("Suresh Kumar");
		e.setSalary(10000);
		
		return e;
		
	}
	
	@Bean(name="emp2")
	public Employee getEmployee2() {
		
		Employee e = new Employee();
		e.setEmpId(200);
		e.setName("Naveen Kumar");
		e.setSalary(20000);
		
		return e;
	}
	
}
