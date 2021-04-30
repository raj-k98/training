package com.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.jpa.entity.Employee;

import com.jpa.repository.EmployeeRepository;


@Service
public class DbInit implements CommandLineRunner {

	@Autowired
	EmployeeRepository employeeRepository;

	Logger logger = LoggerFactory.getLogger(DbInit.class);

	@Override
	public void run(String... args) throws Exception {

		logger.info("H2 datbase empdb created");
		employeeRepository.save(new Employee(100,"Suresh", 22000));
		employeeRepository.save(new Employee(200,"Mahesh", 11000));
		employeeRepository.save(new Employee(300,"Dwivesh", 20000));
		employeeRepository.save(new Employee(400,"Ganesh", 16000));
		employeeRepository.save(new Employee(500,"Dwivesh", 20000));
		employeeRepository.save(new Employee(600,"Ganesh", 10000));

		logger.info("7 rows inserted into employee table");

	}

}
