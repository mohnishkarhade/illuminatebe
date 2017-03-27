package com.niit.illuminatebe.testcase;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.illuminatebe.config.ApplicationContextConfig;
import com.niit.illuminatebe.model.Category;
import com.niit.illuminatebe.service.CategoryService;

import junit.framework.Assert;

public class CategoryTestCase {

	@Autowired
	private static Category category;

	@Autowired
	private static CategoryService categoryService;

	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ApplicationContextConfig.class);

		category = (Category) context.getBean("category");
		categoryService = (CategoryService) context.getBean("categoryService");
	}

	@Test
	public void saveCategoryTest() {
		category.setName("LED");
		category.setDescription("Light emmiting diode");
		
		boolean flag = categoryService.save(category);
		
		Assert.assertEquals("save category test case", true, flag);
	}
	
	@Test
	public void getAllCategories(){
		List<Category> categoryList= categoryService.getAllCategories();
		System.out.println(categoryList);		
	}

}