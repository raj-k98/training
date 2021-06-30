package com.trg.sting.main;

import java.util.Scanner;

public class StringTestMain {

	public static void main(String arg[]) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string");
		String str = sc.nextLine();
// show string vertically		

		for (int i = 0; i < str.length(); i++)
			System.out.println(str.charAt(i));

// reversing a string
		System.out.println("Enter a string to reverse");
		str = sc.nextLine();
		int pos = str.length() - 1;

		String newStr = "";
		for (int i = pos; i >= 0; i--) {
			newStr = newStr + str.charAt(i);
		}

		System.out.println(newStr);

// converting alternate characters to uppercase		

		newStr = "";
		for (int i = 0; i < str.length(); i++) {
			if (i % 2 == 1) {
				// newStr += String.valueOf(str.charAt(i)).toUpperCase();
			
				char ch = str.charAt(i);        //   'e'
				String s = String.valueOf(ch);   //  "e"
				s = s.toUpperCase();            // "E"
				newStr += s;

			} else
				newStr += str.charAt(i);
		}
		System.out.println(newStr);
	}
}
