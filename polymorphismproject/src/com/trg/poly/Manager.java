package com.trg.poly;

public class Manager extends Employee {
	
	private String project;

	public Manager(int empId, String name, float salary, String project) {
		super(empId, name, salary);
		this.project = project;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public int getBonusPercent() {
		return 15;
	}
	

}
