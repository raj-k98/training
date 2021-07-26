package com.trg.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trg.spring.beans.Employee;

public class Spring2Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		Employee e1= ctx.getBean("emp2", Employee.class);
		Employee e2= ctx.getBean("emp2", Employee.class);
		Employee e3= ctx.getBean("emp2", Employee.class);
		
	//	System.out.println(e1);	
		
		ctx.close();

	}

}
