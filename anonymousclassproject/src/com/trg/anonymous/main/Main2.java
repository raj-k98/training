package com.trg.anonymous.main;

import com.trg.anonymous.Operation;

public class Main2 {

	public static void main(String[] args) {
		
       Operation opr;
		
		opr = new Operation() {

			@Override
			public int operate(int x, int y) {
				return x+y;
			}
		  
		};
		
		System.out.println(opr.operate(30, 40));

		
		opr=new Operation(){

			@Override
			public int operate(int x, int y) {
				return x * y;
			}

		};
		
		System.out.println(opr.operate(30, 40));

	}

}
