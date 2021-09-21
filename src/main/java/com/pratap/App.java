package com.pratap;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.pratap.model.Product;
import com.pratap.service.ProductService;

public class App {

	public static void main(String[] args) {

		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

		
		ProductService productService = ctx.getBean(ProductService.class);

		

		productService.add(new Product(1, "Mobile"));
		productService.add(new Product(2, "Laptop"));

		System.out.println("listAll: " + productService.listAll());

		// Test transaction rollback (duplicated key)

	/*	try {
			productService
					.addAll(Arrays.asList(new Product(3, "Book"), new Product(4, "Soap"), new Product(1, "Computer")));
		} catch (DataAccessException dataAccessException) {  }

		// Test element list after rollback
		System.out.println("listAll: " + productService.listAll());*/

		ctx.close();

	}

}
