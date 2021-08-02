package com.trg.emp.boot.dao;

import java.util.List;

import com.capgemini.trg.exceptions.DuplicateEmployeeException;
import com.trg.emp.boot.dto.Employee;

public interface EmployeeDao {
	void save(Employee e);
	boolean update(Employee e);
	boolean delete(int id);
	Employee getEmployee(int id);
	List<Employee> getAllEmployees();

}
