package com.lab.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Lab1Main {

	public static void main(String args[]) {

		HashMap<Integer, String> hm = new HashMap<>();

		hm.put(1, "One");
		hm.put(2, "Two");
		hm.put(3, "Three");
		hm.put(4, "Four");
		
		List<String> list = getValues(hm);
		
		System.out.println(list);

	}

	static List<String> getValues(HashMap<Integer, String> map) {
		
		Collection<String> col= map.values();
		
		ArrayList<String> list = new ArrayList<>();
		list.addAll(col);
		
		
		Collections.sort(list);
		return list;
	}
}
