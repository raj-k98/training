package com.trg.poly;

public class Developer extends Employee {
	private String technology;

	public Developer(int empId, String name, float salary, String technology) {
		super(empId, name, salary);
		this.technology = technology;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}
	
	public int getBonusPercent() {
		return 10;
	}
}
