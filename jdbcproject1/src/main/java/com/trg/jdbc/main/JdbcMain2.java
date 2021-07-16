package com.trg.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trg.jdbc.data.Employee;

public class JdbcMain2 {

	public static void main(String[] args) throws ClassNotFoundException {

		Class.forName("org.postgresql.Driver");
		
		int ids[]= {100,200,999,400,500};
		float sal[]= {1111,2222,9999,4444,5555};

		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres","postgres");

			String sql="update employee set salary=? where empid=?";
			PreparedStatement pst = con.prepareStatement(sql);
			
			
			for(int i=0; i<ids.length;i++) {
				pst.setFloat(1, sal[i]);
				pst.setInt(2, ids[i]);
				
			int x=	pst.executeUpdate();
			
			if(x==1)
				System.out.println("Salary of empid "+ids[i] +" changed to "+sal[i]);
			else
				System.out.println("Employee with id "+ids[i]+" does not exist");
				
			}
						
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
