package com.capgemini.trg.ui;

import java.util.List;

import com.capgemini.trg.dto.Employee;
import com.capgemini.trg.service.EmployeeService;
import com.capgemini.trg.service.EmployeeServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		EmployeeService service = new EmployeeServiceImpl();
		
		Employee x=new Employee(700,"aaa",8000);
		
		if(service.add(x))
			System.out.println("Employee successfully saved");
		else
			System.out.println("Save failed");
	System.out.println("=======  List of Names ============");	
		List<String> names = service.getAllNames();
		
		if(names==null)
			System.out.println("No employee found");
		else
			names.forEach(System.out::println);
		System.out.println("=========Total salary=========");
		float tot = service.getTotalsalary();
		
		System.out.println("Total Salary: "+tot);
		System.out.println("Delete operation=========");
		String dlt = service.delete(100,900,1200,700);
		System.out.println(dlt);
		
		System.out.println("================Update ==============");
		String updt =service.updateSalary(10000f,200,900,1000,100);
		
		System.out.println(updt);
		
	;

	}

}
