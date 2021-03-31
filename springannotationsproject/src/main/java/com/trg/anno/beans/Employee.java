package com.trg.anno.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class Employee {

	int empId;
	String name;
	float salary;

	public Employee(int empId, String name, float salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}

	public String toString() {
		return "EmpId=" + empId + ", name=" + name + ", salary=" + salary;
	}
	

	public void m1() {
		System.out.println("Employee Bean created");
	}

	public void m2() {
		System.out.println("Employee is destroyed");
	}

}


