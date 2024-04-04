package com.ecomerce.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecomerce.commconnection.todatabase.CommonConnection;

public class UserLogin {

	public static void userLogin(String username, String password) {
		
		
		try {
			//get connection
			Connection connection = CommonConnection.getDBConnection();
			
			//create preparedStatment
			String sql = "select * from User where UserName=? and Password=?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			//set values
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			 ResultSet rs = preparedStatement.executeQuery();
				
		    if(rs.next()){
					
			       System.out.println("valid user , Login successfully...");
			}else {
					
					throw new ResourceNotFoundException("user not match please enter correct username and password");
				}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
