package lambdaproject;

import java.util.function.Function;

public class Main3 {

	public static void main(String[] args) {
		
		Function<String, Integer> fn1 = (s) -> s.length();
		
		System.out.println(fn1.apply("Hello"));
		
		Function<String, String> fn2 = (s) -> s.toUpperCase();
		
		System.out.println(fn2.apply("Hello"));
		
		
		
		Function<String,String> c2 = s-> '('+s+')' ;
		
		Function<String,String> c3 = s-> new StringBuffer(s).reverse().toString();
		
		
		
		System.out.println(c2.apply("hello you"));
		
		System.out.println(c3.apply("hello you"));

	}

}
