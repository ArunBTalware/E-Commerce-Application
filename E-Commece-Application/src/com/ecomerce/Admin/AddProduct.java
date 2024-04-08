package com.ecomerce.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ecomerce.commconnection.todatabase.CommonConnection;

public class AddProduct {

	public static void addProduct(String productName, String description, int price, int quantity) {
		
		try {
			//get connection
			Connection connection = CommonConnection.getDBConnection();
			
			//create preparedStatment
			String sql = "insert into Products ( product_name , description, price, quantity) values (?,?,?,?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//set data
			preparedStatement.setString(1, productName);
			preparedStatement.setString(2, description);
			preparedStatement.setInt(3, price);
			preparedStatement.setInt(4, quantity);

			//execute query
			preparedStatement.execute();
			
			System.out.println("Product add successfully...");
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
}
