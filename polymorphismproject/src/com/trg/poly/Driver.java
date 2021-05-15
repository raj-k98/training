package com.trg.poly;

public class Driver extends Employee{
	
	private String licence;

	public Driver(int empId, String name, float salary, String licence) {
		super(empId, name, salary);
		this.licence = licence;
	}

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

  public int getBonusPercent() {
		return 12;
	}
	
}
