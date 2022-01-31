package com.bridgelabz.EmployeePayroll;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class EmployeeDao {

	Connection con = null;

	public EmployeeDao() {

		String jdbcUrl = "jdbc:mysql://localhost:3306/EmployeePayroll";
		String userName = "root";
		String password = "Sumit123@Sumit@123";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(jdbcUrl, userName, password);
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	// To Get All The Employees Available
	public List<Employee> getEmployees() {

		List<Employee> employees = new ArrayList<>();
		String sql = "Select * from employee";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setGender(rs.getString(3));
				e.setCity(rs.getString(4));
				e.setPhoneNo(rs.getLong(5));
				e.setSalary(rs.getLong(6));

				employees.add(e);
			}
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}

		return employees;
	}

	//To Get An Employee Using Id
	public Employee getEmployee(int id) {

		String sql = "Select * from employee where id=" + id;
		Employee e = new Employee();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {

				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setGender(rs.getString(3));
				e.setDepartment(rs.getNString(4));
				e.setCity(rs.getString(5));
				e.setPhoneNo(rs.getLong(6));
				e.setSalary(rs.getLong(7));

			}
		} catch (SQLException e1) {
			System.out.println(e1);
			e1.printStackTrace();
		}

		return e;
	}
	
	//To Create Table For New Employee
	public void create(Employee e1) {
		String sql = "insert into employee values (?,?,?,?,?,?,?)";

		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, e1.getId());
			st.setString(2, e1.getName());
			st.setString(3, e1.getGender());
			st.setString(4, e1.getDepartment());
			st.setString(5, e1.getCity());
			st.setLong(6, e1.getPhoneNo());
			st.setLong(7, e1.getSalary());
			st.executeUpdate();

		} catch (SQLException e2) {
			System.out.println(e2);
			e2.printStackTrace();
		}

	}
	
	//To Update Employee Data
	public void update(Employee e1) {
		String sql = "update employee set name = ?, gender = ?, department = ? ,city = ?, phoneNo = ?, salary = ? where id = ?";

		try {
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, e1.getName());
			st.setString(2, e1.getGender());
			st.setString(3, e1.getDepartment());
			st.setString(4, e1.getCity());
			st.setLong(5, e1.getPhoneNo());
			st.setLong(6, e1.getSalary());
			st.setInt(7, e1.getId());
			st.executeUpdate();

		} catch (SQLException e2) {
			System.out.println(e2);
			e2.printStackTrace();
		}

	}

	////To Delete Employee Data
	public void delete(int id) {

		String sql = "delete from employee where id = ?";

		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();

		} catch (SQLException e1) {
			System.out.println(e1);
			e1.printStackTrace();
		}
	}

}
