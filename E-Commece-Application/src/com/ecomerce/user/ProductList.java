package com.ecomerce.user;

public class ProductList {

	private int id;
	private String product_name;
	private String description;
	private int price;
	private int quantity;
	public ProductList(int id, String product_name, String description, int price, int quantity) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
		
}
