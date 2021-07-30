package com.trg.student.service;

import java.util.List;

import com.trg.crud.exceptions.StudentException;
import com.trg.student.data.Student;

public interface StudentService {
	
	Student getStudent(int id);
	
	void deleteStudent(int id) throws StudentException;
	void saveStudent(Student s) throws StudentException;
	void updateStudent(Student s) throws StudentException;
	
	void raiseMarks(int id, double percent) throws StudentException;
	
	List<Student> getAllStudents();
	
	List<Student> getQulifiedStudents();
	
	List<Student> getStudentsOnAge(int age);
	
	Student getTopper();
	
}
