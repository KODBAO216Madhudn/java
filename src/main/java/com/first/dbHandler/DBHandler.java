package com.first.dbHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBHandler {
public static void insertData(String email, String password, String gender, String address) {
		
	System.out.println("email "+email+" "+password+" "+gender+" "+address);
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost/emp";
		String user="root";
		String pass="root@123";
		String sql="INSERT INTO emp_info values(?,?,?,?)";
		
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, user, pass);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, gender);
			ps.setString(4, address);
			
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
