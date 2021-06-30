package com.trg.sting.main;

public class StringTimeTest {

	public static void main(String[] args) {

		String s = "";

		long start = System.nanoTime();
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			s = s + ch;
		}

		System.out.println(s);
		long end = System.nanoTime();
		System.out.println("Time taken: " + (end - start));

		System.out.println("Now we eill test with StringBuilder");

		StringBuilder sb = new StringBuilder();
		start = System.nanoTime();
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			sb.append(ch);
		}

		System.out.println(sb);
		end = System.nanoTime();
		System.out.println("Time taken: " + (end - start));
		
	}

}
