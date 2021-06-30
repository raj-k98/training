package date.pkg;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {

		Period p = Period.of(2, 5, 0);

		System.out.println(p);

		System.out.println(p.addTo(LocalDate.now()));

		LocalDate dob = LocalDate.of(1998, 5, 21);
		LocalDate today = LocalDate.now();

		Period p1 = Period.between(dob, today);
		System.out.println(p1);

		int age = p1.getYears();
		System.out.println("Age: " + age);

		Scanner sc = new Scanner(System.in);
		String dtstr = sc.next();
		LocalDate ld1 = LocalDate.parse(dtstr);
		System.out.println(ld1);

	}

}
