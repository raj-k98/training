package com.trg.anno.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.trg.anno.beans.ConversionRateProvider;
import com.trg.anno.beans.CurrencyConverter;
import com.trg.anno.beans.Employee;

@Configuration
@ComponentScan(basePackages= {"com"})
@PropertySource("classpath:app.properties")
public class EmpConfiguration {
	
	@Bean(name = "emp1",initMethod = "m1",destroyMethod = "m2")
	public Employee getEmployee1() {
		return new Employee(100,"Srilatha",9000);
	}
	
	
	@Bean(name = "emp2")
	public Employee getEmployee2() {
		return new Employee(200,"Vinod Sharma",19000);
	}
	
	
}
