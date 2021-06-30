package com.trg.sting.main;

import java.util.Scanner;

public class StringBuilderTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// reversing a string
		System.out.println("Enter a string to reverse");
		String str = sc.nextLine();

		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		String newStr = sb.toString();
		System.out.println(newStr);

		newStr = "";
		sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (i % 2 == 1) {
				sb.append(str.substring(i, i + 1).toUpperCase());
			} else
				sb.append(str.charAt(i));
		}
		System.out.println(sb);

	}

}
