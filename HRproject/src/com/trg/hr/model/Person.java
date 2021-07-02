package com.trg.hr.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.trg.hr.enums.Gender;

public class Person {

	private String name;
	private LocalDate dob;
	private Gender gender;
	public Person(String name, LocalDate dob, Gender gender) {
		super();
		this.name = name;
		this.dob = dob;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public void display() {
		System.out.println("Name: "+name);
		System.out.println("Gender: "+gender);
		
		System.out.println("Date of Birth: "+ DateTimeFormatter.ofPattern("dd/MM/yyyy").format(dob));
	}
	
	
	
}
