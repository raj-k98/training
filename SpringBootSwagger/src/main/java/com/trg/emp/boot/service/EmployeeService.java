package com.trg.emp.boot.service;

import java.util.List;

import com.trg.emp.boot.dto.Employee;

public interface EmployeeService {

	Employee get(int id);

	List<Employee> getAll();

	boolean add(Employee e);

	boolean update(Employee e);

	boolean delete(int id);

}
