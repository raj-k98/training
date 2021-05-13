package abc.pqr.xyz;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Employee {
	private int empId;
	private String name;
	private float salary;
	private LocalDate dob;

	public Employee(int empId, String name, float salary, LocalDate dob) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.dob = dob;
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public int getAge() {
		Period p = Period.between(dob, LocalDate.now());
		int age= p.getYears();
		return age;
	}
	
	public void displayData() { // package access

		System.out.println("Employee id: " + empId);
		System.out.println("Name: " + name);
		System.out.println("Salary: " + salary);
		String pdob = dob.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println("Date of Birth: "+pdob);
		System.out.println("Age: "+getAge()+ " years");

	}

}
