package com.ecomerce.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecomerce.commconnection.todatabase.CommonConnection;

public class BuyProduct {

	public static void buyProduct(int user_id,int productId,int selectQuaByUser) {
		
		try {
			//get connection
			Connection connection = CommonConnection.getDBConnection();
			
			//create preparedStatment
			String sql1 = "select * from products where id=?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql1);
			
			preparedStatement.setInt(1, productId);
			ResultSet rs = preparedStatement.executeQuery();
			
			String sql2 = " insert into buy_products (user_id,product_name,no_of_quantity,price,description) values (?,?,?,?,?)";
			
			PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
			preparedStatement1.setInt(1, user_id);
			preparedStatement1.setInt(3,selectQuaByUser);
			
			while(rs.next()) {
				
				String pname=rs.getString(2);
				preparedStatement1.setString(2, pname);
				preparedStatement1.setInt(4,rs.getInt(4));
				preparedStatement1.setString(5,rs.getString(3));
				
				//userselect quantity is greater than avilable quantity of product its not possible
				if(selectQuaByUser > rs.getInt("quantity") ) {
					throw new ResourceNotFoundException("Sorry...product currently unavilable...out_of_stock");
				}
				
			}
			preparedStatement1.execute();
			
			//update quantity in product table after user buy product
			String sql3 = " UPDATE Products SET quantity = (quantity-?) WHERE id = ?";
			PreparedStatement preparedStatement2 = connection.prepareStatement(sql3);
			preparedStatement2.setInt(1, selectQuaByUser);
			preparedStatement2.setInt(2,productId);
			
			preparedStatement2.execute();
			System.out.println("buy product successfully...");
			
		 } catch (SQLException e) {
				
				e.printStackTrace();
	     }
				
		
	}
}
