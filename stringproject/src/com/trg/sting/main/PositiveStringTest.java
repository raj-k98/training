package com.trg.sting.main;

import java.util.Scanner;

public class PositiveStringTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter text");
		String text = sc.nextLine();
		sc.close();
		
		boolean isPositive = true;
		
		char previous = text.charAt(0);
		
		int len = text.length();
		
		for(int i=1;i<len;i++) {
			char present = text.charAt(i);
			
			if(present < previous) {
				isPositive=false;
				break;
			}
			
			previous = present;
		}
		
		if(isPositive)
			System.out.println("the text is positive text");
		else
			System.out.println("text is not positive");

	}

}
