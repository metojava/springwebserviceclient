package com.myshop.client;

import java.util.List;

import com.shop.my.Products;

public interface ProductsService {
	public void customSendAndReceive();
	public Products getProduct(String id) ;
	public List<Products> getProducts();
}
