package date.pkg;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("enter date of purchase");
		String dopStr =sc.next();
		LocalDate dop=LocalDate.parse(dopStr);
		
		System.out.println("enter warrany period in PxYxM");
		String warStr=sc.next();
		Period war=Period.parse(warStr);
		
		System.out.println("Warranty Expires on: "+war.addTo(dop));
		

	}

}
