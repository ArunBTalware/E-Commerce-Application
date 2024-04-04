package com.ecomerce.user;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class UserOperations {

	Scanner sc = new Scanner(System.in);
	
	public void userRegistration() {

		System.out.println("enter first name");
		String first_name = sc.next();

		System.out.println("enter last name");
		String last_name = sc.next();

		System.out.println("enter user name");
		String username = sc.next();

		System.out.println("enter password");
		String password = sc.next();

		System.out.println("enter city name");
		String city = sc.next();

		System.out.println("enter email ");
		String email = sc.next();

		System.out.println("enter mobile no");
		long mobile_no = sc.nextLong();
		
		//call user registration
		UserRegistration.userRegistration(first_name, last_name, username, password, email, city, mobile_no);

	}
	
	public void userLogin() {
		
		System.out.print("enter username>>");
		String username = sc.next();
		System.out.print("enter password>>");
		String password = sc.next();
		//call userLogin()
		UserLogin.userLogin(username, password);
	}
	
	public void productList() {
		
		ViewProducts.viewProducts();
	}

	public static void main(String[] args) {

		UserOperations user = new UserOperations();
		System.out.println("Welcome to E-Commerce based application");

		System.out.println("user operations choose one of the follwing task");
		HashMap<Integer, String> userMap = new HashMap<>();

		userMap.put(1, " User Registration");
		userMap.put(2, " User login");
		userMap.put(3, " User view Product item as Sorted Order");
		userMap.put(4, " Buy Product");
		userMap.put(5, " View Cart");
		userMap.put(6, " Purchase the item");

		for (Entry<Integer, String> e : userMap.entrySet()) // using map.entrySet() for iteration
		{
            System.out.println(e.getKey()+ " "+e.getValue());
		}
		//1
		System.out.print("enetr user choice>>");
		Scanner sc = new Scanner(System.in);
		int userChoice = sc.nextInt();
		
		if(userChoice == 1) {
				
			user.userRegistration();
		}else if(userChoice == 2) {
			
			user.userLogin();
		}else if(userChoice == 3) {
			
			user.productList();
		}
           
		

	}

}
