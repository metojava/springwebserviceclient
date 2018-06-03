package com.myshop.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shop.my.Products;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("client.xml");
		ProductsService service = (ProductsService) ctx.getBean("client");

//		Products prod = service.getProduct("1");
//		System.out.println("product" + prod.getPdescr());

		List<Products> products = service.getProducts();
		for (Products product : products)
			System.out.println(product.toString());
		// service.customSendAndReceive();
	}

	
}
