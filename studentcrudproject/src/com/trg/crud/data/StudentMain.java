package com.trg.crud.data;

import java.util.List;

public class StudentMain {

	public static void main(String[] args) {
		
		StudentDao dao = new StudentDaoMapImpl();
		List<Student> list = dao.getAllStudents();
		display(list);
		
		System.out.println("adding new student object");
		boolean saved =dao.save(new Student(400,"abcd",null,34.5));
		if(saved)
			System.out.println("successfully saved");
		else
			System.out.println("duplicate student data");
		
		list=dao.getAllStudents();
		display(list);
		
		dao.delete(100);
		
		Student st1=dao.getStudent(200);
		if(st1==null)
			System.out.println("not found");
		else
			System.out.println(st1);
		
		System.out.println("after delete 100");
		list=dao.getAllStudents();
		display(list);
		
		Student s= dao.getStudent(200);
		s.setMarks(99.9);
		dao.update(s);
		System.out.println("after update");
		
		list=dao.getAllStudents();
		display(list);

	}

	
	static void display(List<Student> list) {
		
		for(Student s: list) {
			System.out.println(s);
		}
	}
}
