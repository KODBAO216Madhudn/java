package com.first.dbHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Validator {
	public static boolean validate(String email, String pas) {
		
		String dbPass=fetchPass(email);
		System.out.println("Pass "+dbPass);
		if(pas.equals(dbPass)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static String fetchPass(String email) {
		
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost/emp";
		String user="root";
		String pass="root@123";
		String sql="SELECT password FROM emp_info WHERE email=?";
		String db_pass="";
		
		try {
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url, user, pass);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
                db_pass = rs.getString(1);
                System.out.println("Pass " + db_pass);
            }
//			db_pass=rs.getString(1);
			System.out.println("Pass "+db_pass);
		}catch(Exception e) {
			System.out.println("Problem in db");
			e.printStackTrace();
		}
		return db_pass;
	}

}
