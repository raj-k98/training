package com.trg.app.service;

import java.util.List;

import com.trg.app.entity.Employee;
import com.trg.app.exceptions.EmployeeAlreadyExistsException;
import com.trg.app.exceptions.EmployeeNotFoundException;
import com.trg.app.exceptions.SalaryChangeException;

public interface EmpService {
	
	Employee getEmployee(int id);
	void createNewEmployee(Employee e) throws EmployeeAlreadyExistsException;
	void raiseSalary(int eid, float salary) 
			     throws EmployeeNotFoundException, SalaryChangeException;
			     
    Employee removeEmployee(int empId) throws EmployeeNotFoundException;
    List<Employee> getAllemployees();
}
