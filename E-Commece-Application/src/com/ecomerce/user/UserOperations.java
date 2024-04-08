package com.ecomerce.user;
import com.ecomerce.Admin.*;
import com.ecomerce.guest.ViewProductsList;

import java.util.Scanner;

public class UserOperations {

	Scanner sc = new Scanner(System.in);
	//1
	public void userRegistration() {

		System.out.print("enter first name>> ");
		String first_name = sc.next();

		System.out.print("enter last name>> ");
		String last_name = sc.next();

		System.out.print("enter user_name>> ");
		String username = sc.next();

		System.out.print("enter password>> ");
		String password = sc.next();

		System.out.print("enter city name>> ");
		String city = sc.next();

		System.out.print("enter email>> ");
		String email = sc.next();

		System.out.print("enter mobile no>> ");
		long mobile_no = sc.nextLong();
		
		//call user registration
		UserRegistration.userRegistration(first_name, last_name, username, password, email, city, mobile_no);

	}
	//2
	public void userLogin() {
		
		System.out.print("enter username>>");
		String username = sc.next();
		System.out.print("enter password>>");
		String password = sc.next();
		//call userLogin()
		UserLogin.userLogin(username, password);
	}
	//3
	public void productList() {
		
		ViewProducts.viewProducts();
	}
	//4
	public void buyProducts() {
		System.out.print("enter userId>>");
		int userId = sc.nextInt();
		System.out.print("enter productId>>");
		int product_id = sc.nextInt();
		System.out.print("enter quantity>>");
		int quantity = sc.nextInt();
		
		//call method
		BuyProduct.buyProduct(userId, product_id, quantity);
		
	}
	//5
	public void viewCart() {
		System.out.print("enter userId>>");
		int userId = sc.nextInt();
		//call method
		ViewCart.viewCartDetails(userId);
		
	}
	//6
	public void purchaseItem() {
		
		System.out.print("enter userId>>");
		int userId = sc.nextInt();
		//call method
		PurchaseItem.getTotalBillAmount(userId);
	}
	
	//7
	public void addProductByAdmin() {
		

		System.out.print("Enter Product Name >> ");
		String productName = sc.nextLine();
		
		System.out.print("Enter Product Description>> ");
		String description = sc.nextLine();
		
		//sc.nextLine();
		System.out.print("Enter Product Price>> ");
		int price = sc.nextInt();
		
		System.out.print("Enter Product Quantity >>");
		int quantity = sc.nextInt();
		
		//call method
		AddProduct.addProduct(productName, description, price, quantity);
	}
	//8
	public void calculateBillForUser() {
		
		System.out.println("enter user id for that you want to calculate bill...");
		int user_id = sc.nextInt();
		CalculateBillForPerticularUser.billCalculate(user_id);
	}
	
	//10
	public void checkQuantity() {
		
		System.out.print("enter product id to check quantity >> ");
		int product_id = sc.nextInt();
		CheckProductQuantity.checkProductQuantity(product_id);
	}
	
	

	public static void main(String[] args) {

		UserOperations user = new UserOperations();
		System.out.println("******Welcome to E-Commerce based application********");

		System.out.println("-------user operations choose one of the follwing task----------");
	
		System.out.println("1 . User Registration");
		System.out.println("2 . User login");
		System.out.println("3 . User view Product item as Sorted Order");
		System.out.println("4 . Buy Product");
		System.out.println("5 . View Cart");
		System.out.println("6 . Purchase the item");
		
		System.out.println("------------Admin Operations----------------");
		System.out.println("7 . Add Product Item");
		System.out.println("8 .Calculate Bill");
		System.out.println("9 . Display Amount to end user");
		System.out.println("10 . Check Quantity");
		System.out.println("11 . Check registered user");
		System.out.println("12 . Check the particular user history");
		
		System.out.println("------------Guest  Operations----------------");
		
		System.out.println("13 . View Product Item");
			
	while(true) {
		
		//1
		System.out.print("enetr your choice>>");
		Scanner sc = new Scanner(System.in);
		int userChoice = sc.nextInt();
		   
		
		if(userChoice == 1) {
				
			    user.userRegistration();
		   }else if(userChoice == 2) {
			
			    user.userLogin();
		   }else if(userChoice == 3) {
			
			    user.productList();
		   }else if(userChoice == 4) {
			
			    user.buyProducts();
		   }else if(userChoice == 5) {
			
			    user.viewCart();
		   }else if(userChoice == 6) {
			
			    user.purchaseItem();
		   }else if(userChoice == 7) {
				
			    user.addProductByAdmin();
		   }else if(userChoice == 8) {
			
			     user.calculateBillForUser();
		   }else if(userChoice == 10) {
				
			     user.checkQuantity();
		   }else if(userChoice == 11) {
			
			     CheckRegisterUsers.checkUserList();
		   }else if(userChoice == 12) {
			     System.out.print("enetr user_id>>");
		         int user_id	=sc.nextInt();
		         CheckUserHistory.checkUserHistoryById(user_id);
		   }else if(userChoice == 13) {
			
			     ViewProductsList.viewProductListForGuest();
		    }else  {
			
			throw new ResourceNotFoundException("please enter valid userChoice...");
		}
          
		 System.out.print("do you want to contineu shoping ((1)Y/(0)/N) >> ");
		 int num = sc.nextInt();
		 if(num ==0) {
			 System.out.println("Thank you for visit...");
			 break;
		 }
	 
	}
  }

}
