package lambdaproject;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main1 {

	public static void main(String[] args) {
		
		
		Supplier<String> s1 = () -> "Hello world";
		
		Supplier<Integer> s2 = () -> Period.between(LocalDate.of(1989, 10, 12), LocalDate.now()).getYears();
		
		System.out.println(s1.get());
		
		System.out.println(s2.get());
		
		Consumer<String> con1 = (x) -> System.out.println(x.toUpperCase());
		
		con1.accept("hello");
		
		Consumer<Integer> con2 = (x) -> System.out.println(x*x);
		
		con2.accept(23);
		
		BiConsumer<String,Integer> bcon= (x,y) -> System.out.println(x.substring(y));
		
		bcon.accept("hello world", 6);

	}

}
