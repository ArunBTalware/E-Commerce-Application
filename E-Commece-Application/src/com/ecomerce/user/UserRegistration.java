package com.ecomerce.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.ecomerce.commconnection.*;
import com.ecomerce.commconnection.todatabase.CommonConnection;
public class UserRegistration {

	public static void userRegistration(String first_Name,String last_Name,String userName, String password,String email,String city,long mobile_No) {
		
		try {
			//get connection
			Connection connection = CommonConnection.getDBConnection();
			
			//create preparedStatment
			String sql = "insert into User (First_Name , Last_Name , UserName, Password , city , email , Mobile_No) values (?,?,?,?,?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//set data
			preparedStatement.setString(1, first_Name);
			preparedStatement.setString(2, last_Name);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, password);
			preparedStatement.setString(5, city);
			preparedStatement.setString(6, email);
			preparedStatement.setLong(7, mobile_No);
			
			//execute query
			preparedStatement.execute();
			
			System.out.println("user register successfully...");
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
}
