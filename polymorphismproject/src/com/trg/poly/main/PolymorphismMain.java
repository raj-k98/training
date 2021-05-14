package com.trg.poly.main;

import com.trg.poly.Developer;
import com.trg.poly.Driver;
import com.trg.poly.Employee;
import com.trg.poly.Manager;

public class PolymorphismMain {

	public static void main(String[] args) {
		Developer devoloper=new Developer(101, "Srinivas", 25000, "Java");
		Manager manager=new Manager(201,"Kishore",35000,"HSBC");
		Driver driver = new Driver(301, "Aloknath", 15000, "TS123AB");
		
		showDetails(devoloper);
		showDetails(manager);
		showDetails(driver);
	}

	
	static void showDetails(Employee e) {
		System.out.println("Employee Id: "+e.getEmpId());
		System.out.println("Name: "+e.getName());
		System.out.println("Salary: "+e.getSalary());
		float bonus = e.getSalary()*e.getBonusPercent()/100;
		System.out.println("Bonus: "+bonus);
		
	}
}
