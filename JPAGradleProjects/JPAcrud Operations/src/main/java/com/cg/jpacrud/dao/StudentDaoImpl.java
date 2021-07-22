package com.cg.jpacrud.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.jpacrud.entities.Student;

public class StudentDaoImpl implements StudentDao {

	private EntityManager entityManager;

	public StudentDaoImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		entityManager = emf.createEntityManager();
	}

	@Override
	public Student getStudentById(int id) {
		Student student = entityManager.find(Student.class, id);

		return student;
	}

	@Override
	public void addStudent(Student student) {
		entityManager.persist(student);
	}

	@Override
	public void removeStudent(Student student) {
		entityManager.remove(student);
	}

	@Override
	public void updateStudent(Student student) {
		entityManager.merge(student);
	}

	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}
}
