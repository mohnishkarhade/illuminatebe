package com.niit.illuminatebe.testcase;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.niit.illuminatebe.config.ApplicationContextConfig;
import com.niit.illuminatebe.model.Category;
import com.niit.illuminatebe.model.Product;
import com.niit.illuminatebe.model.Supplier;
import com.niit.illuminatebe.service.ProductService;

import junit.framework.Assert;

public class ProductTestCase {

	@Autowired
	private static Product product;
	
	@Autowired
	private static Category category;
	
	@Autowired
	private static Supplier supplier;

	@Autowired
	private static ProductService productService;

	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ApplicationContextConfig.class);

		product = (Product) context.getBean("product");
		productService = (ProductService) context.getBean("productService");
	}

	@Test
	public void saveProductTest() {
		
		MultipartFile file;
		
		product.setName("LED");
		product.setDescription("Light emmiting diode");
		
		product.setPrice(450);
		
		
		
		
		boolean flag = productService.save(product);
		
		Assert.assertEquals("save product test case", true, flag);
	}
	
	@Test
	public void getAllCategories(){
		List<Product> productList= productService.getAllProducts();
		System.out.println(productList);		
	}

}