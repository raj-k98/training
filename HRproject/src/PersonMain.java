import java.time.LocalDate;

import com.trg.hr.enums.Gender;
import com.trg.hr.model.Employee;
import com.trg.hr.model.Person;
import com.trg.hr.model.Student;

public class PersonMain {

	public static void main(String[] args) {

		Person person = new Person("Suresh", LocalDate.of(1898, 12, 5), Gender.MALE);

		person.display();
		System.out.println("==============================================");
		
		Employee employee = new Employee("Samantha Ayyar", LocalDate.of(1999, 12, 5), Gender.FEMALE, 111, 45000);
		employee.display();
		System.out.println("==============================================");
		
		double mks[] = { 65, 87, 92 };
		Student student = new Student("Suresh", LocalDate.of(1898, 12, 5), Gender.MALE, 333, mks);
	

		student.display();
	}

}
