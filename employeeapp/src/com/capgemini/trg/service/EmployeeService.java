package com.capgemini.trg.service;

import java.util.List;

import com.capgemini.trg.dto.Employee;

public interface EmployeeService {

	boolean add(Employee e);

	Employee get(int id);

	List<Employee> getAll();

	boolean delete(int id);

	float getTotalsalary();

	List<String> getAllNames();

	String updateSalary(float salary, int... ids);

	String delete(int... ids);

}
