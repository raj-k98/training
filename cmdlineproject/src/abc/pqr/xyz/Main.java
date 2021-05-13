package abc.pqr.xyz;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import abc.pqr.xyz.Employee;

public class Main {

	public static void main(String[] args) {

		if(args.length != 4) {
			System.out.println("Invalid arguments");
			System.exit(0);
		}
		
		int eid = Integer.parseInt(args[0]);
		String nm = args[1];
		float sal = Float.parseFloat(args[2]);
		LocalDate dob = LocalDate.parse(args[3],DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Employee e= new Employee(eid,nm,sal,dob);
		
		e.displayData();
		
	}

}
