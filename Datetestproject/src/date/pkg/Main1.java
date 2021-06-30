package date.pkg;

import java.time.LocalDate;

public class Main1 {

	public static void main(String[] args) {
		LocalDate ld = LocalDate.of(2020, 12, 25);
		System.out.println(ld);

		System.out.println(ld.getDayOfMonth());
		System.out.println(ld.getDayOfYear());
		System.out.println(ld.getMonthValue());
		System.out.println(ld.getMonth());
		System.out.println("==========================");

		LocalDate today = LocalDate.now();
		System.out.println(today);
		System.out.println(today.getDayOfMonth());
		System.out.println(today.getDayOfYear());
		System.out.println(today.getMonthValue());
		System.out.println(today.getMonth());

		System.out.println("==================");

		LocalDate later = today.plusMonths(4);
		System.out.println(later);

		LocalDate a = today.plusDays(25);

		System.out.println(a);

	}

}
