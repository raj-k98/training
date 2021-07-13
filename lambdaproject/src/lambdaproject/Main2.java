package lambdaproject;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Main2 {

	public static void main(String[] args) {
		
		
		Predicate<String> p1 = (x) -> x.length() > 5;
		
		System.out.println(p1.test("Hello world"));
		
		BiPredicate<Integer,Integer>  bp = (x,y)-> x > y;
		
		System.out.println(bp.test(34, 210));

	}

}
