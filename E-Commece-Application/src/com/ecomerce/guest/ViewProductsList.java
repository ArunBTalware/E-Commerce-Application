package com.ecomerce.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecomerce.commconnection.todatabase.CommonConnection;


public class ViewProductsList {

	public static void viewProductListForGuest() {
		try {
			//get connection
			Connection connection = CommonConnection.getDBConnection();
			
			//create preparedStatment
			String sql = "select * from products";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
		    ResultSet rs = preparedStatement.executeQuery();
			 
			while(rs.next()) {
				 
				System.out.println(rs.getInt(1) +" || "+rs.getString(2)+" || "+rs.getString(3)+" || "+rs.getInt(4)+"||"+rs.getInt(5));
			 }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
