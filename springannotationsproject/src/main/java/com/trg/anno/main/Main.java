package com.trg.anno.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trg.anno.beans.CurrencyConverter;
import com.trg.anno.beans.Employee;
import com.trg.anno.beans.Test;
import com.trg.anno.config.EmpConfiguration;

public class Main {

	public static void main(String[] args) throws IOException {

		ApplicationContext ctx = new  AnnotationConfigApplicationContext(EmpConfiguration.class);

		CurrencyConverter con = (CurrencyConverter) ctx.getBean("abcd");
		System.out.println("4500 " + con.getCurrency() + "s converted to Rupees is " + con.convertToRupees(4500));

		
		Test t =(Test) ctx.getBean("test");
		t.show();
		
		((AnnotationConfigApplicationContext)ctx).close();

	}

}
