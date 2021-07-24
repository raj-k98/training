package com.trg.crud.data;

import java.util.List;

import com.trg.crud.exceptions.StudentException;
import com.trg.student.data.Student;
import com.trg.student.service.StudentService;
import com.trg.student.service.StudentServiceImpl;

public class StudentMain {

	public static void main(String[] args) {
		
		StudentService service = new StudentServiceImpl();
		
		//getting one student
	/*	
		Student s= service.getStudent(800);
		if(s==null) {
			System.out.println("Not found");
		}
		else {
			System.out.println(s);
		}
	
*/
		List<Student> list = service.getStudentsOnAge(20);
		display(list);
		
		System.out.println("List of qualified students");
		
		List<Student> qualified= service.getQulifiedStudents();
		display(qualified);
		
		try {
			service.deleteStudent(189);
			System.out.println("data deleted");
		} catch (StudentException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Topper: "+service.getTopper());
		
	}

	
	static void display(List<Student> list) {
		
		for(Student s: list) {
			System.out.println(s);
		}
	}
}
