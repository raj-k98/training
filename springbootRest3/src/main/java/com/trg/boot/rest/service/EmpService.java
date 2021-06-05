package com.trg.boot.rest.service;

import java.util.List;

import com.trg.boot.rest.entity.Employee;
import com.trg.boot.rest.exceptions.EmployeeAlreadyExistsException;
import com.trg.boot.rest.exceptions.EmployeeNotFoundException;
import com.trg.boot.rest.exceptions.SalaryChangeException;

public interface EmpService {
	
	Employee getEmployee(int id);
	void createNewEmployee(Employee e) throws EmployeeAlreadyExistsException;
	void raiseSalary(int eid, float salary) 
			     throws EmployeeNotFoundException, SalaryChangeException;
			     
    Employee removeEmployee(int empId) throws EmployeeNotFoundException;
    List<Employee> getAllemployees();
}
