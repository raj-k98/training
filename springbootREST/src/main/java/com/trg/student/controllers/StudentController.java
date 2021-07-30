package com.trg.student.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trg.crud.exceptions.StudentException;
import com.trg.student.data.Student;
import com.trg.student.service.StudentService;

@RestController
@RequestMapping("students")
public class StudentController {

	@Autowired
	StudentService service;

	//@RequestMapping(value = "{stdId}", method = RequestMethod.GET)
	@GetMapping("{stdId}")
	public ResponseEntity<?> getStudent(@PathVariable("stdId") int id) {

		Student s = service.getStudent(id);

		if (s != null) {
			return new ResponseEntity<Student>(s, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("student with id " + id + " not found", HttpStatus.NOT_FOUND);
		}
	}

	//@RequestMapping(method = RequestMethod.GET)
	
	@GetMapping
	public List<Student> getAllStudents() {
		List<Student> list = service.getAllStudents();
		return list;
	}

	//@RequestMapping(value = "topper", method = RequestMethod.GET)
	@GetMapping("topper")
	public Student getTopper() {
		Student s = service.getTopper();
		return s;
	}

	
	//@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public ResponseEntity<String> saveStudent(@RequestBody Student s) {

		try {
			service.saveStudent(s);
			return new ResponseEntity<String>("Student with id " + s.getStudentId() + " saved successfully",
					HttpStatus.CREATED);
		} catch (StudentException e) {
			return new ResponseEntity<String>("Save failure!!! "+e.getMessage(),HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping
	public ResponseEntity<String> updateStudent(@RequestBody Student s) {

		try {
			service.updateStudent(s);
			return new ResponseEntity<String>("Student with id " + s.getStudentId() + " updated successfully",
					HttpStatus.CREATED);
		} catch (StudentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("{sid}")
	public ResponseEntity<String> deleteStudent(  @PathVariable("sid") int stdId) {

		try {
			service.deleteStudent(stdId);
			return new ResponseEntity<String>("Student with id " + stdId + " deletedsuccessfully",	HttpStatus.OK);
		} catch (StudentException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
}
