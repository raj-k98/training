package com.trg.util;

public abstract class NumberOperations {

	
	public static int add(int x, int y) {
		return x + y;
	}

	public  static int divide(int x, int y) {
		if(y==0)
			return 0;
		return x / y;
	}

	public static  boolean checkFirstGreater(int x, int y) {
		return x > y;
	}

	public static int getSum(int n) {
		int sum = 0;
		for (int x = 0; x <= n; x++) {
			sum += x;
		}
		return sum;
	}
}
