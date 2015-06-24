package com.myshop.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shop.my.Products;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"client.xml");
		ProductsService service = (ProductsService) ctx.getBean("client");

		Products prod = service.getProduct("1");
		System.out.println("product" + prod.getPdescr());
		
		//service.customSendAndReceive();
	}

}
