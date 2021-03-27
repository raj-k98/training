package com.capgemini.trg.dao;

import java.util.List;

import com.capgemini.trg.dto.Employee;
import com.capgemini.trg.exceptions.DuplicateEmployeeException;

public interface EmployeeDao {
	void save(Employee e)  throws DuplicateEmployeeException;
	boolean update(Employee e);
	boolean delete(int id);
	Employee getEmployee(int id);
	List<Employee> getAllEmployees();

}
