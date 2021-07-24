package com.trg.student.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.trg.crud.exceptions.StudentException;
import com.trg.student.data.Student;

public class StudentDaoJpaImpl implements StudentDao {

	EntityManagerFactory emf;
	EntityManager em;

	public StudentDaoJpaImpl() {
		emf = Persistence.createEntityManagerFactory("JPA-PU");
		em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(new Student(100, "Kumar", LocalDate.of(1999, 10, 5), 25.6));
		em.persist(new Student(200, "Srinidhi", LocalDate.of(2005, 11, 25), 56.5));
		em.persist(new Student(300, "Mahesh", LocalDate.of(2002, 1, 15), 82.5));
		em.getTransaction().commit();
	}

	@Override
	public void save(Student s) throws StudentException {

		if (em.find(Student.class, s.getStudentId()) != null)
			throw new StudentException("Student with id " + s.getStudentId() + " already exists");

		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
	}

	@Override
	public void update(Student s) throws StudentException {

		if (em.find(Student.class, s.getStudentId()) != null) {

			em.getTransaction().begin();
			em.merge(s);
			em.getTransaction().commit();

		} else
			throw new StudentException("Student with id " + s.getStudentId() + " does not exist");

	}

	@Override
	public void delete(int sid) throws StudentException {

		Student st = em.find(Student.class, sid);
		if (st != null) {
			em.getTransaction().begin();
			em.remove(st);
			em.getTransaction().commit();
		} else
			throw new StudentException("Student with id " + sid + " does not exist");

	}

	@Override
	public Student getStudent(int sid) {

		return em.find(Student.class, sid);
	}

	@Override
	public List<Student> getAllStudents() {
		TypedQuery<Student> query = em.createQuery("from Student", Student.class);
		List<Student> list = query.getResultList();
		return list;
	}

}
