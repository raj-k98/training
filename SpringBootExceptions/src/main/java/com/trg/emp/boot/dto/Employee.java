package com.trg.emp.boot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "emp")

public class Employee {
	@Id
	@Column(name = "empid")
	private int empId;

	//@NotEmpty(message = "Name should not be Empty")
	@NotNull(message = "Name is Required")
	@Length(min = 5, max = 20,message="Length of name sgould be betwwen 5 and 20")
	private String name;

	@Range(min = 10000, max = 35000,message="Salary should be in the range of 10000 and 35000")
	private float salary;

	public Employee() {

	}

	public Employee(int empId, String name, float salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
	}

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

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmpId=" + empId + ", name=" + name + ", salary=" + salary;
	}

}
