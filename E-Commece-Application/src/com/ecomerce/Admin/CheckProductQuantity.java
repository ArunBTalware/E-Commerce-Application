package com.ecomerce.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecomerce.commconnection.todatabase.CommonConnection;

public class CheckProductQuantity {

	public static void checkProductQuantity(int product_id) {
		
		try {
			//get connection
			Connection connection = CommonConnection.getDBConnection();
			
			//create preparedStatment
			String sql = "select product_name,quantity from products where id=? ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, product_id);
			
			ResultSet rs = preparedStatement.executeQuery();
			
            while(rs.next()) {
				
				System.out.println("Product Name >>"+rs.getString(1));	
				System.out.println("Available Quantity >>"+rs.getInt(2));
			} 
			
		} catch (SQLException e) {
			
			e.printStackTrace();
     }
		
	}
}
