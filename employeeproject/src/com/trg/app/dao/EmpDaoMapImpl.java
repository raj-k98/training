package com.trg.app.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.trg.app.entity.Employee;

public class EmpDaoMapImpl implements EmpDao {
	Map<Integer, Employee> database = new HashMap<>();

	public EmpDaoMapImpl() {
		database.put(100, new Employee(100, "Kiran", 8000));
		database.put(200, new Employee(200, "Atul Kumar", 12000));
		database.put(300, new Employee(300, "Narendra Singh", 15000));
		database.put(400, new Employee(400, "Nidhi Kaur", 14000));
		database.put(500, new Employee(500, "Sunil Rao", 22000));
	}

	@Override
	public boolean save(Employee e) {
		if (database.containsKey(e.getEmpId()))
			return false;
		database.put(e.getEmpId(), e);
		return true;
	}

	@Override
	public boolean update(Employee e) {
		if (database.containsKey(e.getEmpId())) {
			database.put(e.getEmpId(), e);
			return true;
		}
		return false;
	}

	@Override
	public Employee delete(int empId) {

		Employee e = database.get(empId);
		if (e != null) {
			database.remove(empId);
		}
		return e;
	}

	@Override
	public Employee getEmployee(int empid) {
		Employee e = database.get(empid);
		return e;
	}

	@Override
	public List<Employee> getAllEmployees() {
		Collection<Employee> col = database.values();
		List<Employee> list = new ArrayList<Employee>();

		list.addAll(col);
		return list;
	}

}
