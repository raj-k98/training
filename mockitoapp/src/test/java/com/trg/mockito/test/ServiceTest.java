package com.trg.mockito.test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.trg.mockito.db.DataBase;
import com.trg.mockito.service.Service;

@ExtendWith(MockitoExtension.class)
class ServiceTest {

	@Mock
	DataBase mockDb;

	@Test
	public void testGetSalary() {

		when(mockDb.getSalary(100)).thenReturn(5000);

		Service service = new Service(mockDb);
		assertEquals(5000,service.getSalary(100));
	}

	@Test
	public void testGetName() {
		when(mockDb.getName(100)).thenReturn("Sudhir");
		when(mockDb.getName(200)).thenReturn("Ambareesh");

		Service service = new Service(mockDb);
		assertEquals("Sudhir", service.getName(100));
		assertEquals("Ambareesh", service.getName(200));

	}

}