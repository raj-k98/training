package com.trg.app.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.trg.app.entity.Employee;

public class EmpDaoJpaImpl implements EmpDao {

	EntityManager em;

	public EmpDaoJpaImpl() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPA-PU");
		em= emf.createEntityManager();
	}

	@Override
	public boolean save(Employee e) {

		try {
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
			return true;

		} catch (EntityExistsException ex) {
			return false;
		}
	}

	@Override
	public boolean update(Employee e) {

		if (em.find(Employee.class, e.getEmpId()) != null) {
			em.getTransaction().begin();
			em.merge(e);
			em.getTransaction().commit();
			return true;
		}
		return false;
	}

	@Override
	public Employee delete(int id) {

		Employee e = em.find(Employee.class, id);
		if (e != null) {
			em.getTransaction().begin();
			em.remove(e);
			em.getTransaction().commit();
			return e;
		}
		return null;
	}

	@Override
	public Employee getEmployee(int id) {
		return em.find(Employee.class, id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		Query q = em.createQuery("from Employee");
		List<Employee> list = q.getResultList();
		return list;
	}
}
