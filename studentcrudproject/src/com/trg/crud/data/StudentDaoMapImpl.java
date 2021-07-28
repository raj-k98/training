package com.trg.crud.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StudentDaoMapImpl implements StudentDao {

	Map<Integer, Student> data = new TreeMap<>();

	public StudentDaoMapImpl() {
		data.put(100, new Student(100, "Kumar", LocalDate.of(1999, 10, 5), 75.6));
		data.put(200, new Student(200, "Srinidhi", LocalDate.of(2005, 11, 25), 56.5));
		data.put(300, new Student(300, "Mahesh", LocalDate.of(2002, 1, 15), 82.5));
	}

	@Override
	public boolean save(Student s) {

		if (data.containsKey(s.getStudentId()))
			return false;
		data.put(s.getStudentId(), s);
		return true;
	}

	@Override
	public boolean update(Student s) {

		if (data.containsKey(s.getStudentId())) {
			data.replace(s.getStudentId(), s);
			return true;
		}

		return false;
	}

	@Override
	public boolean delete(int sid) {
		if (data.containsKey(sid)) {
			data.remove(sid);
			return true;
		}

		return false;
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
