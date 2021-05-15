package enumsproject;

import abc.GenderValue;

public class Employee {
	private int empId;
	private String name;
	private GenderValue gender;

	public Employee(int empId, String name, GenderValue gender) {
		super();
		this.empId = empId;
		this.name = name;
		this.gender = gender;
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

	public GenderValue getGender() {
		return gender;
	}

	public void setGender(GenderValue gender) {
		this.gender = gender;
	}

	public void show() {
		System.out.println("Id: " + empId);
		System.out.println("Name: " + name);
		System.out.println("Gender: "+gender.getDescription());

	}

}
