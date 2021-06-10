package com.trg.emp.boot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.trg.emp.boot.dto.Employee;
import com.trg.emp.boot.repo.EmployeeRepository;

@Component
public class EmployeeInit  implements CommandLineRunner{
	@Autowired
	EmployeeRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Employee(100, "Suresh", 7000));
		repository.save(new Employee(200, "Naresh", 17000));
		repository.save(new Employee(300, "Mahesh", 27000));
		repository.save(new Employee(400, "Ganesh", 37000));
	}
	
	
}
