package com.ecomerce.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
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
			 
			 
			 //its for user cart
			 Scanner sc = new Scanner(System.in);
			 
			 System.out.println("do you want to add product in card(Y/N)>> ");
			 char ch =sc.nextLine().charAt(0);
			 System.out.print("enter your user_id >> ");
			 int user_id = sc.nextInt();
			 
			 
			 while(ch == 'Y') {
				 
				 System.out.print("enter product_id you want to add in your cart >> ");
				 int product_id = sc.nextInt();
				
				 String sql1 = "select * from  products where id=?";
				 
				 preparedStatement = connection.prepareStatement(sql1);
				 preparedStatement.setInt(1, product_id);
				
				 ResultSet rs1 = preparedStatement.executeQuery();
				
				 String sql2 = "insert into view_cart (user_id,  product_name, description,price) values(?,?,?,?)";
				 preparedStatement = connection.prepareStatement(sql2);
				 
				 while(rs1.next()) {
					 
					 preparedStatement.setInt(1, user_id);
					 preparedStatement.setString(2, rs1.getString(2));
					 preparedStatement.setString(3, rs1.getString(3));
					 preparedStatement.setInt(4, rs1.getInt(4));
					 
					 preparedStatement.execute();
					 
					 System.out.println("product insert successfully in cart...");
				 }
				 
				 System.out.print("do you want to continue(1(yes)/0(no))>> ");
				 int num = sc.nextInt();
				 if(num == 0) {
					break; 
				 }
			 }
			 
           } catch (SQLException e) {
			
			e.printStackTrace();
		   }
			
	}
}
