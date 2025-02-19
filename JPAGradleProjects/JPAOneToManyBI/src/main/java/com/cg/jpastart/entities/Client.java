package com.cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Run onetomanybi.sql DDL before executing this program

public class Client {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		// create a new department
		Department department = new Department();
		department.setId(10);
		department.setName("Sales");

		// create two instances of employees
		Employee e1 = new Employee();
		e1.setId(1001);
		e1.setName("Priya Sharma");
		e1.setSalary(4500);
		e1.setDepartment(department);
		
		Employee e2 = new Employee();
		e2.setId(1002);
		e2.setName("Dinesh Kumar");
		e2.setSalary(5500);
		e2.setDepartment(department);

		department.getEmployees().add(e1);
		department.getEmployees().add(e2);
		// save department and its employees using entity manager
		em.persist(department);

		System.out.println("Added department along with two employees to database.");

		Department d = new Department();
		d.setId(20);
		d.setName("H R");

		Employee e3 = new Employee();
		e3.setId(1003);
		e3.setName("Sreekumar");
		e3.setSalary(15000);
		e3.setDepartment(d);
		em.persist(e3);   // department with id 20 is created
		
		Employee e4 = new Employee();
		e4.setId(1004);
		e4.setName("Lakshmi Nair");
		e4.setSalary(25000);
		e4.setDepartment(d);
		em.persist(e4);  // department with id 20 is updated

		System.out.println("Added two employees with department");
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
