 package com.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class VehicleRegisterDB {
	
	static Connection connection = null;
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","1234");
		
		}catch (Exception e) {
			System.out.println("Connection unsuccessful");
		}
		
		return connection;
	}
}
