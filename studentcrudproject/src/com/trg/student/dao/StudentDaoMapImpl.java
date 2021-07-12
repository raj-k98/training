package com.trg.student.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.trg.crud.exceptions.StudentException;
import com.trg.student.data.Student;

public class StudentDaoMapImpl implements StudentDao {

	Map<Integer, Student> data = new TreeMap<>();

	public StudentDaoMapImpl() {
		data.put(100, new Student(100, "Kumar", LocalDate.of(1999, 10, 5), 25.6));
		data.put(200, new Student(200, "Srinidhi", LocalDate.of(2005, 11, 25), 56.5));
		data.put(300, new Student(300, "Mahesh", LocalDate.of(2002, 1, 15), 82.5));
	}

	@Override
	public void save(Student s) throws StudentException {

		if (data.containsKey(s.getStudentId()))
			throw new StudentException("Student with id " + s.getStudentId() + " already exists");
		data.put(s.getStudentId(), s);

	}

	@Override
	public void update(Student s) throws StudentException {

		if (data.containsKey(s.getStudentId())) {
			data.replace(s.getStudentId(), s);

		} else
			throw new StudentException("Student with id " + s.getStudentId() + " does not exist");

	}

	@Override
	public void delete(int sid) throws StudentException {
		if (data.containsKey(sid)) {
			data.remove(sid);
		} else
			throw new StudentException("Student with id " + sid + " does not exist");

	}

	@Override
	public Student getStudent(int sid) {

		return data.get(sid);
	}

	@Override
	public List<Student> getAllStudents() {
		Collection<Student> col = data.values();
		List<Student> list = new ArrayList<>();
		list.addAll(col);
		return list;
	}

}
