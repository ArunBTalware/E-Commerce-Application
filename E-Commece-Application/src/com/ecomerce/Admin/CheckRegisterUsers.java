package com.ecomerce.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecomerce.commconnection.todatabase.CommonConnection;

public class CheckRegisterUsers {

	public static void checkUserList() {
		
		try {
			//get connection
			Connection connection = CommonConnection.getDBConnection();
			
			//create preparedStatment
			String sql = "select * from User ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
	
			ResultSet rs = preparedStatement.executeQuery();
			System.out.println("id"+"||"+"first_name"+"||"+"Last Name"+" || "+"User name"+"||"+"passwoard"+
			" || "+" city  "+"||"+"   email    "+"  || "+"   mobile no  ");
            while(rs.next()) {
				
			   System.out.println(rs.getInt(1)+" || "+rs.getString(2)+" || "+rs.getString(3)+" || "+rs.getString(4)+
						" || "+rs.getString(5)+"|| "+rs.getString(6)+" || "+rs.getString(7)+" ||"+rs.getLong(8));
			} 
			
		} catch (SQLException e) {
			
			e.printStackTrace();
     }
	}
}
