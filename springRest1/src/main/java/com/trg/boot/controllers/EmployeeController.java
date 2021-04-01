package com.trg.boot.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trg.boot.beans.Employee;

@RestController
@RequestMapping("employees")
public class EmployeeController {

	
	@RequestMapping(value="show")
	public Employee getEmp2() {
		return new Employee(100,"Naresh",8000);
	}
	
	@GetMapping("show")
	public String Val() {
		return "Hello Wortd";
	}
	@RequestMapping("showAll")
	public List<Employee> getAllEmployees(){
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(100,"Naresh",8000));
		list.add(new Employee(200,"Kiran",25000));
		list.add(new Employee(300,"Arun",22000));
		return list;
	}

}
