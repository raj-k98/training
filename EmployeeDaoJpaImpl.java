package com.capgemini.trg.dao;

import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.trg.dto.Employee;
import com.capgemini.trg.exceptions.DuplicateEmployeeException;

public class EmployeeDaoJpaImpl implements EmployeeDao {

	EntityManagerFactory factory;
	EntityManager em;

	public EmployeeDaoJpaImpl() {
		factory = Persistence.createEntityManagerFactory("EMPPU");
		em = factory.createEntityManager();

	}

	@Override
	public void save(Employee e) throws DuplicateEmployeeException {
		try {
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
		} catch (EntityExistsException ex) {
			throw new DuplicateEmployeeException("Employee you supplied is duplicate");
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
	public boolean delete(int id) {

		Employee e = em.find(Employee.class, id);
		if (e != null) {
			em.getTransaction().begin();
			em.remove(e);
			em.getTransaction().commit();
			return true;
		}
		return false;
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
