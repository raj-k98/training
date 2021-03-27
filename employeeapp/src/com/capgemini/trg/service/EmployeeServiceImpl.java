package com.capgemini.trg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.trg.dao.EmployeeDao;
import com.capgemini.trg.dao.EmployeeDaoMapImpl;
import com.capgemini.trg.dto.Employee;
import com.capgemini.trg.exceptions.DuplicateEmployeeException;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao dao = new EmployeeDaoMapImpl();

	@Override
	public boolean add(Employee e) {

		try {
			dao.save(e);
			return true;
		} catch (DuplicateEmployeeException e1) {
			return false;

		}
	}

	@Override
	public List<Employee> getAll() {
		return dao.getAllEmployees();
	}

	@Override
	public boolean delete(int id) {
		return dao.delete(id);
	}

	@Override
	public float getTotalsalary() {

		double totSal = dao.getAllEmployees().stream().mapToDouble(Employee::getSalary).sum();

		return (float) totSal;
	}

	@Override
	public List<String> getAllNames() {
		List<Employee> list = dao.getAllEmployees();
		if (list.size() == 0)
			return null;

		return list.stream().map(Employee::getName).collect(Collectors.toList());

	}

	@Override
	public Employee get(int id) {

		return dao.getEmployee(id);
	}

	@Override
	public String updateSalary(float salary, int... ids) {
		
		List<String> message = new ArrayList<>();
		
		for(int id:ids) {
			Employee e = dao.getEmployee(id);
			if(e==null) {
				message.add("Employee with id "+id +" does not exist");
			}
			else {
				e.setSalary(salary);
				dao.update(e);
				message.add("salary of employee id "+id +" updated successfully");
			}
		}
		
		String s = message.stream().collect(Collectors.joining("\n"));
		return s;
		
	}

	@Override
	public String delete(int... ids) {

		List<String> message = new ArrayList<>();
		
		for(int id:ids) {

			if(dao.delete(id)) {
				message.add("Employee with id "+id+" succesfully deleted");
			}
			else {
			
				message.add("Employee with id "+id +" does not exist");
			}
		}
		
		String s = message.stream().collect(Collectors.joining("\n"));
		return s;
	}

}
