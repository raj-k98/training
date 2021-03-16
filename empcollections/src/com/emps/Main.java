package com.emps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();

		list.add(new Employee(100, "Sudhir", 10, 15000));
		list.add(new Employee(200, "Vivek", 20, 25000));
		list.add(new Employee(300, "Arun", 20, 5000));
		list.add(new Employee(400, "John", 30, 9000));
		list.add(new Employee(500, "Sridhar", 30, 35000));
		list.add(new Employee(600, "Vishnu", 10, 11000));
		list.add(new Employee(700, "Lokesh", 10, 18000));
		
		
		Map<Integer,List<Employee>> m = segregate(list);    // List<Employee> is the value
		
		Set<Integer> deptNos = m.keySet();
		
		for(Integer deptid:deptNos) {
			System.out.println("Dept Id: "+deptid);
			List<Employee> l = m.get(deptid);
			
			for(Employee e : l)
				System.out.println(e);
		}
			
	}

	static Map<Integer, List<Employee>> segregate(List<Employee> lst) {

		Map<Integer, List<Employee>> map = new TreeMap<>();

		for (Employee e : lst) {

			List<Employee> l = map.get(e.getDeptId());

			if (l == null) {
				l = new ArrayList<Employee>();
				l.add(e);
				map.put(e.getDeptId(), l);

			} else {
				l.add(e);
			}
		}

		return map;
	}

}
