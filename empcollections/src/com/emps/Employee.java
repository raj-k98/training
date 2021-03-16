package com.emps;

public class Employee implements Comparable<Employee> {

	private int empId;
	private String name;
	private int deptId;
	private float salary;

	public Employee(int empId, String name, int deptId, float salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.deptId = deptId;
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
	public int compareTo(Employee o) {
		return this.empId - o.empId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empId != other.empId)
			return false;
		return true;
	}

}
