package com.lab.main;

import java.util.Map;
import java.util.TreeMap;

public class Lab2Main {

	public static void main(String[] args) {
		
		char ch[] = {'a','b','a','x','h','w','x','e','y','a'};
				
		Map<Character, Integer> m = countChars(ch);
		
		System.out.println(m);
		
	}

	
	static Map<Character, Integer>  countChars(char[] chars){
		
		Map<Character,Integer> map=new TreeMap<>();
		
		for(char ch:chars) {
			if(map.containsKey(ch)) {
			
				int count = map.get(ch);
				count++;
				map.put(ch, new Integer(count));
				
			}
			else {
				map.put(ch,1);
			}
		}
		
		return map;
	}
}
