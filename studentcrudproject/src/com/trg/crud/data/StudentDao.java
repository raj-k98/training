package com.trg.crud.data;

import java.util.List;

public interface StudentDao {

	boolean save(Student s); // Create

	boolean update(Student s); // Update

	boolean delete(int sid); // Delete

	Student getStudent(int sid);  //Retireve

	List<Student> getAllStudents(); // Retieve

}
