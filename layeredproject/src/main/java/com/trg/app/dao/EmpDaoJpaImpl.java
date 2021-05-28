package com.trg.app.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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


		return false;
	}

	@Override
	public Employee delete(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployee(int empid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
