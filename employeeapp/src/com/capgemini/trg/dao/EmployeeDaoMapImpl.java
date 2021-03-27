package com.capgemini.trg.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.capgemini.trg.dto.Employee;
import com.capgemini.trg.exceptions.DuplicateEmployeeException;

public class EmployeeDaoMapImpl implements EmployeeDao {

	Map<Integer, Employee> data = new HashMap<Integer, Employee>();

	public EmployeeDaoMapImpl() {
		data.put(100, new Employee(100, "Ramana", 45000));
		data.put(200, new Employee(100, "Harini", 12000));
		data.put(300, new Employee(100, "Kishore", 18000));
		data.put(400, new Employee(100, "Kiran", 25000));
		data.put(500, new Employee(500, "Suresh", 15000));
	}

	@Override
	public void save(Employee e) throws DuplicateEmployeeException {
		if (data.containsKey(e.getEmpId()))
			throw new DuplicateEmployeeException("Employee with id " + e.getEmpId() + " already exists");
		data.put(e.getEmpId(), e);
	}

	@Override
	public boolean update(Employee e) {

		if (data.containsKey(e.getEmpId())) {
			data.put(e.getEmpId(), e);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id) {

		if (data.containsKey(id)) {
			data.remove(id);
			return true;
		}

		return false;
	}

	@Override
	public Employee getEmployee(int id) {
		return data.get(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return data.values().stream().collect(Collectors.toList());
	}

}
