package com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpDao implements EmployeeDAO {
//	ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
	// Object obj1 = ctx.getBean("mgr");
	public void insert(Employee emp) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "Akash@20");
			// here sonoo is database name, root is username and password
			PreparedStatement stmt = con
					.prepareStatement("insert into emp(ename,salary,role,username,password) values(?,?,?,?,?)");
			stmt.setString(1, emp.getEname());
			stmt.setString(3, emp.getRole());
			stmt.setDouble(2, emp.getSalary());
			// stmt.setInt(5,emp.getId());
			stmt.setString(4, emp.getUsername());
			stmt.setString(5, emp.getPassword());
			stmt.executeUpdate();
			// stmt.executeQuery();

			// System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void update(Employee emp) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "Akash@20");

//PreparedStatement stmt=con.prepareStatement("Update emp "+""
			// + "set salary = ?,role = ?, username = ?, password = ?"+
			// "where id = ?");

			// update users set num_points = ? where first_name = ?";
			PreparedStatement stmt = con
					.prepareStatement("insert into emp(id, ename,salary,role,username,password) values(?,?,?,?,?,?)");
			stmt.setString(1, Integer.toString(emp.getId()));
			stmt.setString(2, emp.getEname());
			stmt.setString(3, Double.toString(emp.getSalary()));
			System.out.println(emp.getSalary());
			stmt.setString(4, emp.getRole());
			// stmt.setInt(5,emp.getId());
			stmt.setString(5, emp.getUsername());
			stmt.setString(6, emp.getPassword());

			System.out.println("update:" + emp.getId());

			System.out.println(emp);

			stmt.executeUpdate();
			System.out.println(emp);

			// System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void delete(Employee emp) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "Akash@20");
			// here sonoo is database name, root is username and password
			PreparedStatement stmt = con.prepareStatement("delete from emp where id = ?");
			// delete from emp where id = 109;
			System.out.println(emp.getId());
			stmt.setString(1, Integer.toString(emp.getId()));
			// System.out.println(emp.getId());
			// stmt.setInt(5,emp.getId());
			stmt.executeUpdate();
			// stmt.executeQuery();

			// System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public Employee search(String id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "Akash@20");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from emp");

			// ResultSet rs=stmt.executeQuery("select * from emp");
			while (rs.next()) {
				if ((rs.getString(1).equals(id))) {
					System.out.println("search prm:" + id);
					Employee obj = new Employee();
					obj.setId(Integer.valueOf(id));
					System.out.println("search:" + obj.getId());
					obj.setEname(rs.getString(2));
					obj.setRole(rs.getString(4));
					String sal = (rs.getString(3));
					obj.setSalary(Double.parseDouble(sal));
					obj.setUsername((rs.getString(5)));
					obj.setPassword(rs.getString(6));
					return obj;
				}
			}

			// System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public void display() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "Sapient123");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from emp");

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
