package com.trg.app.service;

import java.util.List;

import com.trg.app.dao.EmpDao;
import com.trg.app.dao.EmpDaoDbImpl;
import com.trg.app.dao.EmpDaoMapImpl;
import com.trg.app.entity.Employee;
import com.trg.app.exceptions.EmployeeAlreadyExistsException;
import com.trg.app.exceptions.EmployeeNotFoundException;
import com.trg.app.exceptions.SalaryChangeException;

public class EmpServiceImpl implements EmpService {

	EmpDao dao = new EmpDaoDbImpl();

	@Override
	public Employee getEmployee(int id) {
		return dao.getEmployee(id);
	}

	@Override
	public void createNewEmployee(Employee e) throws EmployeeAlreadyExistsException, NullPointerException {
		if (e == null)
			throw new NullPointerException("Employee object cannot be  null");

		boolean createSuccess = dao.save(e);
		if (!createSuccess)
			throw new EmployeeAlreadyExistsException("Employee with Id " + e.getEmpId() + " already exists");
	}

	@Override
	public void raiseSalary(int eid, float salary) throws EmployeeNotFoundException, SalaryChangeException {
		Employee emp = dao.getEmployee(eid);
		if (emp == null)
			throw new EmployeeNotFoundException("Employee with Id " + eid + " does not exist");
		if (salary < emp.getSalary())
			throw new SalaryChangeException("existing salary " + emp.getSalary() + " cannot be reduced to " + salary);

		emp.setSalary(salary);
		dao.update(emp);
	}

	@Override
	public Employee removeEmployee(int empId) throws EmployeeNotFoundException {
		Employee emp = dao.delete(empId);
		if (emp == null)
			throw new EmployeeNotFoundException("Employee with id " + empId + " to delete does not exist");
		return emp;
	}

	@Override
	public List<Employee> getAllemployees() {
		return dao.getAllEmployees();
	}

}