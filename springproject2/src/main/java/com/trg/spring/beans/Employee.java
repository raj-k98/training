package com.trg.spring.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Employee {

	private int empId = 100;
	private String name = "Suresh Kumar";
	private int salary = 10000;

	@Autowired
	private Department department;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "EmpId: " + empId + " Name: " + name + " Salary: " + salary + " \n" + department;
	}

	@PostConstruct
	public void initialize() {
		System.out.println("Employee bean created with empid: "+empId);
	}
	
	@PreDestroy
	public void close() {
		System.out.println("Employee bean with id: "+empId+" destroyed");
	}
	
}
