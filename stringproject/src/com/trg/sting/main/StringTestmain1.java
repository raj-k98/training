package com.trg.sting.main;

public class StringTestmain1 {

	public static void main(String args[]) {

		String s1 = new String("hello"); // creates new object
		String s2 = new String("HELLO"); // creates new object

		// s1 == s2 is false
		// to compare we have to use equals() or equalsIgnoreCase() methods
		System.out.println(s1.equalsIgnoreCase(s2));

		String s3 = "abcd"; // refers value in string pool
		String s4 = "abcd"; // refers value in string pool
		// both s3 and s4 have same reference value

		System.out.println(s3 == s4); // true as both s3 and s4 refer to the same object in pool

	}

}
