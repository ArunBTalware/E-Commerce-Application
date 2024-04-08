package com.ecomerce.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecomerce.commconnection.todatabase.CommonConnection;

public class CalculateBillForPerticularUser {

	public static void billCalculate(int user_id){
		
		try {
			//get connection
			Connection connection = CommonConnection.getDBConnection();
			
			//create preparedStatment
			String sql = "select user_id, SUM(no_of_quantity * price ) as total_bill from buy_products where user_id=? ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, user_id);
			
			ResultSet rs = preparedStatement.executeQuery();
			
            while(rs.next()) {
				
				System.out.println("user Id >>"+rs.getInt(1));	
				System.out.println("Total Bill Amount >>"+rs.getInt(2));
			} 
			
		} catch (SQLException e) {
			
			e.printStackTrace();
     }
		
	}
	
}
