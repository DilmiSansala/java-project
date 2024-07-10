package db;

import java.sql.Connection;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class DbConnect {
	
	
	static Connection connection = null;
	
	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","1234");
		
		}catch (Exception e) {
			System.out.println("Connection unsuccessful");
		}
		
		return connection;
	}
}
