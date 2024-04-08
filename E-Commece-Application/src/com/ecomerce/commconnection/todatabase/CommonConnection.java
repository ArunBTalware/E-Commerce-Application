package com.ecomerce.commconnection.todatabase;
import java.sql.*;
public class CommonConnection {

	public static Connection getDBConnection() {
		
		Connection connection = null;
		try {
			//1.load driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
		    
			//2.create connection
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/E_Commerce_Application","root", "arun123");
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		
		return connection;
	}
}
