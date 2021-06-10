package com.trg.emp.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trg.emp.boot.dto.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}

