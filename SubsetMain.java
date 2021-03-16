package collectionsproject2;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SubsetMain {

	public static void main(String[] args) {
		SortedSet<Integer> ss = new TreeSet<Integer>();
		
		ss.add(23);
		ss.add(98);
		ss.add(6);
		ss.add(9);
		ss.add(57);
		ss.add(48);
		ss.add(100);
		
		System.out.println(ss);
		
		Set<Integer> subs = ss.subSet(5, 24);
		System.out.println(subs);
		
		subs.add(10);
		System.out.println("=================");
		System.out.println(ss);
		System.out.println(subs);
		
		
		ss.add(18);
		ss.add(88);
		ss.remove(6);
		System.out.println("=================");
		System.out.println(ss);
		System.out.println(subs);

	}

}
