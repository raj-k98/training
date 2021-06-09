package com.boot;

import com.boot.model.Employee;
import com.boot.repository.EmployeeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmployeeInit implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeInit.class);

	@Autowired
	private EmployeeRepository repo;

	@Override
	public void run(String... args) throws Exception {

		logger.info("Saving Employees");

		repo.save(new Employee("Sunil", "Kumar", "sunil@howmaol.com"));
		repo.save(new Employee("Ajay", "Jain", "ajay@howmaol.com"));
		repo.save(new Employee("Spurti", "Reddy", "spurti@howmaol.com"));
		repo.save(new Employee("Siddarth", "Reddy", "siddarth@howmaol.com"));
	}
}
