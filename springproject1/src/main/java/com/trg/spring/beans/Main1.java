package com.trg.spring.beans;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class Main1 {

	public static void main(String[] args) {
		
	//	Resource  rs = new ClassPathResource("customer.xml");
	//	BeanFactory bf =  new XmlBeanFactory(rs);
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("customer.xml");
		
	//	Product p = ctx.getBean("p1",Product.class);
		
	//	System.out.println(p);
		
		Address add1 = ctx.getBean("address1", Address.class);
		Address add2 = ctx.getBean("address1", Address.class);
		Address add3 = ctx.getBean("address1", Address.class);
		Address add4 = ctx.getBean("address1", Address.class);
		
		
		System.out.println(add1);
		System.out.println(add2);
		System.out.println(add3);
		System.out.println(add4);
		
		System.out.println("============ after changing add1 =========");
		
		add1.setCity("Kolkotta");
		
		System.out.println(add1);
		System.out.println(add2);
		System.out.println(add3);
		System.out.println(add4);
	}

}
