package com.classes;


import java.sql.*;

public class JbeanDb{  
	
public boolean check(String un,String pwd) {
	//int i=0;
	try {
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
	"jdbc:mysql://localhost:3306/data","root","Akash@20");  
	//here sonoo is database name, root is username and password  
	Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery("select * from emp");  
	while(rs.next()) {
		if((rs.getString(5).equals(un)) && (rs.getString(6).equals(pwd))&& (rs.getString(4).equals("admin"))){
			//i=1;
			return true;
		}
	}
	
	//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
	con.close();
	
	}
catch(Exception e){ System.out.println(e);
	}  
	return false;	
}


public void insert(String name,String address, String Phone_Number ,String uname,String pwd) {
	
	try {
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/data","root","Sapient123");  
		//here sonoo is database name, root is username and password  
		PreparedStatement stmt=con.prepareStatement("insert into userInfo values(?,?,?,?,?)");
		stmt.setString(1, name);
		stmt.setString(2, address);
		stmt.setString(3, Phone_Number);
		stmt.setString(4, uname);
		stmt.setString(5, pwd);
		stmt.executeUpdate();  
		//stmt.executeQuery();  
		
		
		//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
		con.close();
		
		}
	catch(Exception e){ System.out.println(e);
		}  
}
}
