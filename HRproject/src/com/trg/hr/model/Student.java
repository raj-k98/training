package com.trg.hr.model;

import java.time.LocalDate;
import java.util.Arrays;

import com.trg.hr.enums.Gender;

public class Student extends Person {

	private int studentId;
	private double marks[];

	public Student(String name, LocalDate dob, Gender gender, int studentId, double[] marks) {
		super(name, dob, gender);
		this.studentId = studentId;
		this.marks = marks;
	}

	public int getStudentId() {
		return studentId;
	}

	public double[] getMarks() {
		return marks;
	}

	public void setMarks(double[] marks) {
		this.marks = marks;
	}

	@Override
	public void display() {
		System.out.println("Student Id: " + studentId);
		super.display();
		System.out.println("Marks: " + Arrays.toString(marks));
	}

}
