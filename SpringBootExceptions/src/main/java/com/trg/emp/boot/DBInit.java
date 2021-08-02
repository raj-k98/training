package com.trg.emp.boot;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.trg.emp.boot.dto.Employee;
import com.trg.emp.boot.repo.EmployeeRepository;

@Component
public class DBInit implements CommandLineRunner {

	@Autowired
	EmployeeRepository repo;
	
	Logger logger = LoggerFactory.getLogger(DBInit.class);
	
	@Override
	public void run(String... args) throws Exception {
		
		logger.info("H2 datbase empdb created");
		repo.save(new Employee(100,"Suresh",22000));
		repo.save(new Employee(300,"Mahesh",11000));
		repo.save(new Employee(400,"Dwivesh",20000));
		repo.save(new Employee(500,"Ganesh",16000));
		repo.save(new Employee(600,"Dwivesh",20000));
		repo.save(new Employee(700,"Ganesh",10000));
		
		logger.info("7 rows inserted into employee table");

	}
	
}
