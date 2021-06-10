package com.trg.emp.boot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.trg.emp.boot.dto.Employee;
import com.trg.emp.boot.service.EmployeeService;

@RestController
@RequestMapping("employees")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping("{eid}")
	public ResponseEntity<?> getEmployee(@PathVariable("eid") int empId) {
		Employee e = service.get(empId);
		
		if(e==null)
			return new ResponseEntity<String>("Employee wit id "+empId + " not found", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Employee>(e,HttpStatus.OK);
	}

	@GetMapping
	public List<Employee> getAllEmployee() {
		return service.getAll();
	}

	@PostMapping
	public String saveEmployee(@RequestBody Employee e) {
		if (service.add(e))
			return "Employee Data successfully saved";
		else
			return "Employee data is duplicate";
	}

	@PutMapping
	public String updatemployee(@RequestBody Employee e) {
		if (service.update(e))
			return "Employee data successfully updated";
		else
			return "Employee to update not found";
	}

	@DeleteMapping("{eid}")
	public String deleteEmployee(@PathVariable("eid") int id) {
		if (service.delete(id))
			return "Employee data successfully deleted";
		else
			return "Employee to delete not found";
	}

	@DeleteMapping
	public String deleteEmployee1(@RequestParam("eid") int id) {
		if (service.delete(id))
			return "Employee data successfully deleted";
		else
			return "Employee to delete not found";
	}

	@PostMapping("{eid}/{name}/{salary}")
	public String saveEmployeeWithArguments(@PathVariable("eid") int empId, @PathVariable("name") String nm,
			@PathVariable("salary") float sal) {
		Employee e = new Employee();
		e.setEmpId(empId);
		e.setName(nm);
		e.setSalary(sal);
		if (service.add(e))
			return "Employee Data successfully saved";
		else
			return "Employee data is duplicate";
	}

	@PatchMapping("{eid}/{salary}")
	public String updateSalary(@PathVariable("eid") int id, @PathVariable("salary") float sal) {
		Employee e = service.get(id);
		if (e == null)
			return "Employee for salary update not found";
		e.setSalary(sal);
		service.update(e);
		return "Employee salary updated succssfully";
	}
}
