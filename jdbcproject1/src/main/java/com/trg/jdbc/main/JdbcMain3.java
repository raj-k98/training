package com.trg.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trg.jdbc.data.Department;

public class JdbcMain3 {

	public static void main(String[] args) {
		
		List<Department> list=new ArrayList<>();
		
		list.add(new Department(30, "Technical"));
		list.add(new Department(40, "Infra"));
		list.add(new Department(50, "Finance"));
		
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres","postgres");

			String sql="insert into department values(?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			
			for(Department  d : list) {
				
				pst.setInt(1, d.getDeptId());
				pst.setString(2, d.getDeptName());
				
				pst.executeUpdate();
			}
						
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		

	}

}
