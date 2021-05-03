package com.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.jpa.entity.Employee;
import com.jpa.entity.User;
import com.jpa.repository.EmployeeRepository;
import com.jpa.repository.UserRepository;

@Service
public class DbInit implements CommandLineRunner {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	UserRepository userRepository;

	Logger logger = LoggerFactory.getLogger(DbInit.class);

	@Override
	public void run(String... args) throws Exception {

		employeeRepository.save(new Employee(100, "Dinesh", 22000));
		employeeRepository.save(new Employee(200, "Ganesh", 11000));
		employeeRepository.save(new Employee(300, "Mahesh", 20000));
		employeeRepository.save(new Employee(400, "Naresh", 16000));
		employeeRepository.save(new Employee(500, "Ritesh", 20000));
		employeeRepository.save(new Employee(600, "Suresh", 10000));

		logger.info("Data inserted into employee table");
		
		userRepository.save(new User("ramana","ramana","admin"));
		userRepository.save(new User("suresh","suresh","user"));
		userRepository.save(new User("naresh","naresh","user"));
		
		logger.info("Users ramana, suresh, naresh created");
	}

}
