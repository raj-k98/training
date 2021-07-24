package com.trg.jpa.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.trg.crud.exceptions.StudentException;
import com.trg.student.dao.StudentDao;
import com.trg.student.dao.StudentDaoJpaImpl;
import com.trg.student.data.Student;
import com.trg.student.service.StudentService;
import com.trg.student.service.StudentServiceImpl;

class StudentServiceTest1 {

	StudentService service;

	@BeforeEach
	public void initialize() {

		StudentDao dao = new StudentDaoJpaImpl();
		service = new StudentServiceImpl(dao);
	}

	@Test
	public void testGetStudent() {

		Student s = service.getStudent(100);
		String name=s.getName();
		
		assertEquals("Kumar",name);
	}
	
	@Test
	public void testDeleteStudent() {
		try {
			service.deleteStudent(100);
			
			Student s = service.getStudent(100);
			assertNull(s);
			
		} catch (StudentException e) {
			fail("Delete not working properly");
		}
		
	}
	

}
