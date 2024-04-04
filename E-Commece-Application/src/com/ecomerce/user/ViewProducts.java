package com.ecomerce.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.ecomerce.commconnection.todatabase.CommonConnection;

public class ViewProducts {

	public static void viewProducts() {
		
		List<ProductList> productList = new ArrayList<>(); 
		
		try {
			//get connection
			Connection connection = CommonConnection.getDBConnection();
			
			//create preparedStatment
			String sql = "select * from products";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			 ResultSet rs = preparedStatement.executeQuery();
			 
			 while(rs.next()) {
				 
				 productList.add(new ProductList(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5)));
			 }
			 
			 //sort product based on name
			 Collections.sort(productList, new CompareProductName());
			 //iterate sorted products
			 System.out.println("id  |"+"|  "+" Product_Name  |"+"|        Description             |"+"| price   |"+"|  quantity  |");
			 for(ProductList p : productList) {
				 
				 System.out.println(p.getId() +" || "+p.getProduct_name()+" || "+p.getDescription()+" || "+p.getPrice()+"||"+p.getQuantity());
			 }
           } catch (SQLException e) {
			
			e.printStackTrace();
		   }
			
	}
}
