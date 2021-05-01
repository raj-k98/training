package com.jpa.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.entity.Employee;
import com.jpa.exceptions.EmployeeNotFoundException;
import com.jpa.exceptions.EmptyDataException;
import com.jpa.exceptions.InvalidUserException;
import com.jpa.jwt.JwtTokenUtil;
import com.jpa.service.EmployeeService;

import io.jsonwebtoken.SignatureException;

@RestController
@RequestMapping("employees")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpController {

	@Autowired
	EmployeeService service;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@GetMapping(value = "{eid}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("eid") int empId,HttpServletRequest request) {
		validateToken(request);
		Employee e = service.get(empId);

		if (e == null)
			throw new EmployeeNotFoundException("Request", "Employee with id " + empId + " not found");

		return new ResponseEntity<Employee>(e, HttpStatus.OK);
	}

	@GetMapping
	public List<Employee> getAllEmployee(HttpServletRequest request) {
		validateToken(request);
		List<Employee> list = service.getAll();
		if (list.size() == 0)
			throw new EmptyDataException("No employees in database");

		return list;

	}

	@PostMapping
	public String saveEmployee(@Valid @RequestBody Employee e,HttpServletRequest request) {
		validateToken(request);
		service.add(e);
		return "Employee Data successfully saved";

	}

	@PutMapping
	public String updatemployee(@Valid @RequestBody Employee e,HttpServletRequest request) {
		validateToken(request);
		if (service.update(e))
			return "Employee data successfully updated";
		else
			throw new EmployeeNotFoundException("Update", "Employee with Id " + e.getEmpid() + " to update not found");
	}

	@DeleteMapping("{eid}")
	public String deleteEmployee(@PathVariable("eid") int id,HttpServletRequest request) {
		validateToken(request);
		if (service.delete(id))
			return "Employee data successfully deleted";
		else
			throw new EmployeeNotFoundException("Delete", "Employee with Id " + id + " to delete not found");
	}

	public void validateToken(HttpServletRequest request) {
		final String tokenHeader = request.getHeader("Authorization");

		String jwtToken = null;

		if (tokenHeader == null)
			throw new InvalidUserException("User Not Logged In or token not included");
		// JWT Token is in the form "Bearer token". Remove Bearer word
		if (!tokenHeader.startsWith("Bearer "))
			throw new InvalidUserException("Invalid Token");

		jwtToken = tokenHeader.substring(7);
		try {
			if (!(jwtTokenUtil.validateToken(jwtToken)))
				throw new InvalidUserException("Token Expired. Need Relogin");

		} catch (SignatureException ex) {
			throw new InvalidUserException("Invalid Token");
		}
	}

}
