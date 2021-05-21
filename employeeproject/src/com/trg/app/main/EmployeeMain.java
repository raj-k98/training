package com.trg.app.main;

import java.util.List;
import java.util.Scanner;

import com.trg.app.entity.Employee;
import com.trg.app.exceptions.EmployeeNotFoundException;
import com.trg.app.exceptions.SalaryChangeException;
import com.trg.app.service.EmpService;
import com.trg.app.service.EmpServiceImpl;

public class EmployeeMain {

	public static void main(String[] args) {
		EmpService service = new EmpServiceImpl();
		/*
		 * List<Employee> list = service.getAllemployees();
		 * System.out.println("List of All Employees"); for (Employee e : list) {
		 * System.out.println(e); }
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee id to view Details");
		int eid = sc.nextInt();

		// Getting Employee data for id entered by the user
		Employee emp = service.getEmployee(eid);
		if (emp != null)
			System.out.println(emp);
		else
			System.out.println("Employee not found");

		// Update alary of Employee salary

		System.out.println("Enter Emp id to change salary");
		eid = sc.nextInt();
		System.out.println("Enter new salary");
		float sal = sc.nextFloat();
		try {
			service.raiseSalary(eid, sal);
			System.out.println("Salary of Employee with id " + eid + " changed to " + sal);

			System.out.println(service.getEmployee(eid));
		} catch (EmployeeNotFoundException | SalaryChangeException e1) {
			System.out.println(e1.getMessage());
		}

		sc.close();
	}

}
