package com.trg.jdbc.main;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

import com.trg.jdbc.data.Employee;

public class JdbcMain1 {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		
		List<Employee> list = new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "postgres");
			
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("select empid, name, salary,deptid  from employee");

			while (rs.next()) {
				int eid = rs.getInt(1);
				String name = rs.getString(2);
				float sal = rs.getFloat(3);
				int did = rs.getInt(4);

				Employee e = new Employee(eid, name, did, sal);
				list.add(e);
			}

			
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

			list.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);

			System.out.println(list.stream().count());

			Map<Integer, Double> map = list.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.summingDouble(Employee::getSalary)));

			map.forEach(   (k,v) -> System.out.println("Total Salary of Department "+k +": "+v));

	}

}
