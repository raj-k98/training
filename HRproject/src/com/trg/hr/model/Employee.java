package com.trg.hr.model;

import java.time.LocalDate;

import com.trg.hr.enums.Gender;

public class Employee extends Person {
	private int empId;
	private int salary;

	public Employee(String name, LocalDate dob, Gender gender, int empId, int salary) {
		super(name, dob, gender);
		this.empId = empId;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public void display() {
		System.out.println("Emp Id: "+empId);
		super.display();
		System.out.println("Salary: "+salary);
	}

}
