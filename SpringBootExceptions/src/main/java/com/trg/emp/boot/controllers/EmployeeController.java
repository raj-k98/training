package com.trg.emp.boot.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.trg.exceptions.EmployeeNotFoundException;
import com.capgemini.trg.exceptions.EmptyDataException;
import com.trg.emp.boot.DBInit;
import com.trg.emp.boot.dto.Employee;
import com.trg.emp.boot.service.EmployeeService;

@RestController
@RequestMapping("employees")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping(value = "{eid}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("eid") int empId) {
		Employee e = service.get(empId);

		if (e == null)
			throw new EmployeeNotFoundException("Request", "Employee with id " + empId + " not found");

		return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}

	@GetMapping
	public List<Employee> getAllEmployee() {

		List<Employee> list = service.getAll();
		if (list.size() == 0)
			throw new EmptyDataException("No employees in database");

		return list;

	}

	@PostMapping
	public String saveEmployee(  @Valid @RequestBody Employee e) {
		service.add(e);
		return "Employee Data successfully saved";

	}

	@PutMapping
	public String updatemployee( @Valid @RequestBody Employee e) {
		if (service.update(e))
			return "Employee data successfully updated";
		else
			throw new EmployeeNotFoundException("Update", "Employee with Id " + e.getEmpId() + " to update not found");
	}

	@DeleteMapping("{eid}")
	public String deleteEmployee(@PathVariable("eid") int id) {
		if (service.delete(id))
			return "Employee data successfully deleted";
		else
			throw new EmployeeNotFoundException("Delete", "Employee with Id " + id + " to delete not found");
	}

}
