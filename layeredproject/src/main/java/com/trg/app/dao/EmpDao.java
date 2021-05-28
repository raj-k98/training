package com.trg.app.dao;

import java.util.List;

import com.trg.app.entity.Employee;

public interface EmpDao {

	boolean save(Employee e);

	boolean update(Employee e);

	Employee delete(int empId);

	Employee getEmployee(int empid);

	List<Employee> getAllEmployees();
}
