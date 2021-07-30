package com.trg.emp.boot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.trg.emp.boot.dto.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
	List<Employee> findByName(String name);  // from Employee e where e.name=:name
	List<Employee> findBySalary(float salary);

}

