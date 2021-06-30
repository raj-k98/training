package com.trg.sting.main;

public class StringTestmain1 {

	public static void main(String args[]) {

		String s= "ABCD";
		
		StringBuilder sb = new StringBuilder(s);
		System.out.println(s+sb.reverse());
		
		
		String s1=s;
		for(int i =s.length()-1;i>=0;i--) {
			s1 =s1 + s.charAt(i);
		}
		System.out.println(s1);
	}

}

