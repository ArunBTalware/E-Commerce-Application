package com.ecomerce.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecomerce.commconnection.todatabase.CommonConnection;

public class ViewCart {

	public static void viewCartDetails(int user_id) {
		
		try {
			//get connection
			Connection connection = CommonConnection.getDBConnection();
			
			//create preparedStatment
			String sql = "select * from view_cart where user_id=?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, user_id);
			
			ResultSet rs = preparedStatement.executeQuery();
			
            while(rs.next()) {
				
				System.out.println(rs.getString(3)+" || "+rs.getString(4)+" || "+rs.getInt(5));	
			} 
			
		} catch (SQLException e) {
			
			e.printStackTrace();
     }
	}
}
