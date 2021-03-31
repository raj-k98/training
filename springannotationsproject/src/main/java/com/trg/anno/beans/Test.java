package com.trg.anno.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Test {
	
	@Autowired
	@Qualifier("emp1")
	private Employee emp;
	
	
	public void show() {
		
		System.out.println(emp);
	}

}
