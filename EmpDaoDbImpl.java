package com.trg.app.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.trg.app.entity.Employee;

public class EmpDaoDbImpl implements EmpDao {

	Connection con;

	public EmpDaoDbImpl() {

		InputStream inp = getClass().getClassLoader().getResourceAsStream("jdbc.properties");

		Properties prop = new Properties();
		try {
			prop.load(inp);
			Class.forName(prop.getProperty("driver"));

			con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
					prop.getProperty("password"));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	@Override
	public boolean save(Employee e) {

		try {
			PreparedStatement pst = con.prepareStatement("insert into employee values(?,?,?)");

			pst.setInt(1, e.getEmpId());
			pst.setString(2, e.getName());
			pst.setFloat(3, e.getSalary());

			pst.executeUpdate();

			return true;

		} catch (SQLException e1) {
			return false;
		}
	}

	@Override
	public boolean update(Employee e) {
		try {
			PreparedStatement pst = con.prepareStatement("update employee set name=?, salary=? where empid=?");

			pst.setInt(3, e.getEmpId());
			pst.setString(1, e.getName());
			pst.setFloat(2, e.getSalary());

			int x = pst.executeUpdate();
			if (x == 0)
				return false;
			return true;

		} catch (SQLException e1) {
			return false;
		}

	}

	@Override
	public Employee delete(int empId) {

		try {
			Employee e = getEmployee(empId);
			if (e == null)
				return null;
			PreparedStatement pst = con.prepareStatement("delete from employee where empid=?");
			pst.setInt(1, empId);

			pst.executeUpdate();

			return e;

		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public Employee getEmployee(int empid) {
		try {
			PreparedStatement pst = con.prepareStatement("select * from employee where empid=?");
			pst.setInt(1, empid);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				int eid = rs.getInt(1);
				String nm = rs.getString(2);
				float sal = rs.getFloat(3);

				Employee e = new Employee(eid, nm, sal);
				return e;
			} else {
				return null;
			}

		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		try {

			List<Employee> list = new ArrayList<Employee>();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from employee");
			while (rs.next()) {
				int eid = rs.getInt(1);
				String nm = rs.getString(2);
				float sal = rs.getFloat(3);

				Employee e = new Employee(eid, nm, sal);
				list.add(e);
			}

			return list;

		} catch (SQLException e) {
			return new ArrayList<Employee>();
		}
	}

}
