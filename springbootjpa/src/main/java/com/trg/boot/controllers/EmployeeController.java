package com.trg.boot.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trg.boot.entity.Employee;
import com.trg.boot.exceptions.DuplicateEmployeeException;
import com.trg.boot.exceptions.EmployeeCreateException;
import com.trg.boot.exceptions.EmployeeNotFoundException;
import com.trg.boot.repo.EmployeeRepository;

@RestController
@RequestMapping("employees")
public class EmployeeController {

	@Autowired
	EmployeeRepository dao;

	@GetMapping()
	public List<Employee> getEmployees() {
		List<Employee> list = (List<Employee>) dao.findAll();
		return list;
	}

	@GetMapping("{eid}")
	public ResponseEntity<Employee> getEmployee(@Valid @PathVariable("eid") int empId) {

		Optional<Employee> opt = dao.findById(empId);

	//	Employee x= dao.getOne(empId);
		
		if (opt.isPresent())
			return new ResponseEntity<Employee>(opt.get(), HttpStatus.OK);

		throw new EmployeeNotFoundException("Employee with id " + empId + " not found");
	}

	@PostMapping()
	public ResponseEntity<String> saveEmployee(@Valid @RequestBody Employee emp) {

		Optional<Employee> opt = dao.findById(emp.getEmpId());
		if (opt.isPresent())
			throw new EmployeeCreateException("Employee Id " + emp.getEmpId() + " already exists");

		dao.save(emp);
		return new ResponseEntity<String>("Employee data successfully saved", HttpStatus.CREATED);

	}

	@PutMapping()
	public ResponseEntity<String> updateEmployee(@RequestBody Employee emp) {
		Optional<Employee> opt = dao.findById(emp.getEmpId());
		if (!(opt.isPresent()))
			throw new EmployeeNotFoundException("Employee to update not found");

		dao.save(emp);
		return new ResponseEntity<String>("Employee data successfully update", HttpStatus.ACCEPTED);

	}

	@DeleteMapping("{eid}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("eid") int empId) {

		Optional<Employee> opt = dao.findById(empId);
		if (!opt.isPresent()) {
			throw new EmployeeNotFoundException("Employee to delete not found");
		}
		
		dao.deleteById(empId);
		return new ResponseEntity<>("Employee with id: " + empId + " successfully deleted", HttpStatus.ACCEPTED);

	}

}
