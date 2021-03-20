package streamsproject;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


import java.io.ObjectInputStream.GetField;
import java.time.*;

public class Main1 {

	public static void main(String[] args) {
	
		
		List<Employee> emps=EmployeeRepository.getEmployees();
		List<Department> depts = EmployeeRepository.getDepartments();
		
		System.out.println("=============== department wise wise total no of employees ================");
				Map<String, Long> countMap = 
				
			       emps.stream()
			            .filter(e-> e.getDepartment() != null)
			            .collect(Collectors.groupingBy(e -> e.getDepartment().getDepartmentname(), Collectors.counting()));  
			       
			       countMap.forEach((k,v)-> System.out.println("Department: "+k+" No of employees: "+v));
			       
			       
		System.out.println("======== department wise total no of employees  in TreeMap ===============");
		emps.stream()
		.filter(e-> e.getDepartment() != null)
		.collect(Collectors.groupingBy(e-> e.getDepartment().getDepartmentname() ,TreeMap::new,Collectors.counting()))
		.forEach( (k,v)-> System.out.println(k +"\t"+v));
		
		
		System.out.println("========== designation wise total salary of all employees ==============");
		Map<String, Double> sumMap =
		
	      emps.stream()
	            .collect(Collectors.groupingBy(e -> e.getDesignation(), Collectors.summingDouble(e->e.getSalary())));  
	       
	       sumMap.forEach((k,v)-> System.out.println("Designation: "+k+" Total salary: "+v));
	       
	      System.out.println("=============== details of seniormost employee  ======================");
	     emps.stream().sorted(Comparator.comparing(Employee::getHireDate)).limit(1).forEach(System.out::println);
		
	     System.out.println("============List of employee names along with completed no of years and months =======");
		
		emps.stream()
		
		.forEach(e-> System.out.println(e.getFirstName()+" "+e.getLastName()+ " completed "+ 
		            Period.between(e.getHireDate(),LocalDate.now()).getYears() + " years and "+
				    Period.between(e.getHireDate(),LocalDate.now()).getMonths()+ " months"));	   	 
		
		 System.out.println("============List of departments not having employees=================");
		depts.stream()
		    .filter(d-> (emps.stream().noneMatch(e->e.getDepartment() != null && e.getDepartment().getDepartmentId()==d.getDepartmentId())))
		    .forEach(System.out::println);
	   
	}

}
