package com.trg.sting.main;

public class StringBuilderTest1 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("Hyderabad is capital of Telangana");
		System.out.println(sb);
		sb.delete(5, 10);
		System.out.println(sb);
		sb.append(", India");
		System.out.println(sb);
		
		sb.insert(6, 354);
		
		System.out.println(sb);
	}

}
