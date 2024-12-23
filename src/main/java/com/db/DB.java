package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	
	public static Connection getDbCon() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb","root","");
			return con;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}

