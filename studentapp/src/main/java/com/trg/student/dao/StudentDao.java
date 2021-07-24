package com.trg.student.dao;

import java.util.List;

import com.trg.crud.exceptions.StudentException;
import com.trg.student.data.Student;

public interface StudentDao {

	void save(Student s) throws StudentException; // Create

	void update(Student s) throws StudentException; // Update

	void delete(int sid) throws StudentException; // Delete

	Student getStudent(int sid);  //Retireve

	List<Student> getAllStudents(); // Retieve

}
