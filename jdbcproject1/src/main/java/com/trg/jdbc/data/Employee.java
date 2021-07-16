package com.trg.jdbc.data;

public class Employee implements Comparable<Employee> {

	private int empId;
	private String name;
	private int deptId;
	private float salary;

	public Employee(int empId, String name, int deptId, float salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.deptId=deptId;
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

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "EmpId=" + empId + ", name=" + name + ", deptId=" + deptId + ", salary=" + salary;
	}

	@Override
	public int compareTo(Employee e) {
		return this.empId - e.empId;
	}

}
