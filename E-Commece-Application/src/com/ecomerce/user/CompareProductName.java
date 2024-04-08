package com.ecomerce.user;

import java.util.Comparator;

public class CompareProductName implements Comparator<ProductList> {

	@Override
	public int compare(ProductList p1, ProductList p2) {
		
		return p1.getProduct_name().compareTo(p2.getProduct_name());
	}

	
}
