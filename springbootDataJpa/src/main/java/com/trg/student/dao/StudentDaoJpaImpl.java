package com.trg.student.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.StudentRepository;
import com.trg.crud.exceptions.StudentException;
import com.trg.student.data.Student;

@Service
public class StudentDaoJpaImpl implements StudentDao {

	@Autowired
	private StudentRepository repository;

	@Override
	public void save(Student s) throws StudentException {

		if (repository.existsById(s.getStudentId()))
			throw new StudentException("Student with id " + s.getStudentId() + "already exits");
		else
			repository.save(s);
	}

	@Override
	public void update(Student s) throws StudentException {

		if (repository.existsById(s.getStudentId()))
			repository.save(s);
		else
			throw new StudentException("Student with id " + s.getStudentId() + "does not exist");
	}

	@Override
	public void delete(int sid) throws StudentException {

		if (repository.existsById(sid))
			repository.deleteById(sid);
		else
			throw new StudentException("Student with id " + sid + "does not exist");

	}

	@Override
	public Student getStudent(int sid) {

		Optional<Student> opt = repository.findById(sid);
		if (opt.isPresent())
			return opt.get();
		else
			return null;
	}

	@Override
	public List<Student> getAllStudents() {

		ArrayList<Student> list = (ArrayList<Student>) repository.findAll();
		return list;
	}

}
