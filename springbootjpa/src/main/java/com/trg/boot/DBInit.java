package com.trg.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.trg.boot.entity.Employee;
import com.trg.boot.repo.EmployeeRepository;

@Component
public class DBInit implements CommandLineRunner {

	@Autowired
	EmployeeRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		repo.save(new Employee(100,"Ramana",5600));
		repo.save(new Employee(200,"Kishore",8500));
		repo.save(new Employee(300,"Geetha",15600));
		repo.save(new Employee(400,"Siromani",8500));
	}
}
