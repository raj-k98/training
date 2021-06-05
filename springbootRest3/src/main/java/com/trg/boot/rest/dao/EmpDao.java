package com.trg.boot.rest.dao;

import java.util.List;

import com.trg.boot.rest.entity.Employee;

public interface EmpDao {

	boolean save(Employee e);

	boolean update(Employee e);

	Employee delete(int empId);

	Employee getEmployee(int empid);

	List<Employee> getAllEmployees();
}
