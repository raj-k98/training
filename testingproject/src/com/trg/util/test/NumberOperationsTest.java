package com.trg.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.trg.util.NumberOperations;

class NumberOperationsTest {
	int count= 0;
	
	@BeforeEach
	void show() {
		count++;
		System.out.println("Test case "+ count );
	}

	@Test
	void testNaturalSum() {
         int result = NumberOperations.getSum(5);
         assertEquals(15, result);
	}
	
	@Test
	void testAddNumbers() {
		int result = NumberOperations.add(23, 45);
		assertEquals(68, result,"Add method failing");
	}
	
	@Test
	void testGreater() {
		assertTrue(NumberOperations.checkFirstGreater(30, 20));
	}
	
	@Test
	void correctDivide() {
		int result = NumberOperations.divide(30, 4);
		assertEquals(7,result);
	}
	
	@Test
	void assertZeroDivide() {
		try {
			int result = NumberOperations.divide(32, 0);
			fail("Method not throwing exception with zero divide");
		}
		catch(ArithmeticException ae) {
			assertTrue(true);
		}
	}
}
