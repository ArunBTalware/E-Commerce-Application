package com.ecomerce.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecomerce.commconnection.todatabase.CommonConnection;

public class CheckUserHistory {

	public static void checkUserHistoryById(int user_id) {
		
		try {
			//get connection
			Connection connection = CommonConnection.getDBConnection();
			
			//create preparedStatment
			String sql = "select * from buy_products where user_id=? ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, user_id);
			
			ResultSet rs = preparedStatement.executeQuery();
			System.out.println("usrer histroy for id>>"+user_id);
			System.out.println("product name     ||"+"  product_description   ||"+"no_of_buy_product");
            while(rs.next()) {
				
				System.out.println(rs.getString(3)+" || "+rs.getString(6)+" ||"+rs.getInt(4));	
				
			} 
			
		} catch (SQLException e) {
			
			e.printStackTrace();
     }
		
	}
	
}
