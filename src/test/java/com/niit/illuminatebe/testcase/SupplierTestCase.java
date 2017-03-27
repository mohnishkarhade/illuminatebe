package com.niit.illuminatebe.testcase;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.illuminatebe.config.ApplicationContextConfig;
import com.niit.illuminatebe.model.Supplier;
import com.niit.illuminatebe.service.SupplierService;

import junit.framework.Assert;

public class SupplierTestCase {

	@Autowired
	private static Supplier supplier;

	@Autowired
	private static SupplierService supplierService;

	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ApplicationContextConfig.class);

		supplier = (Supplier) context.getBean("supplier");
		supplierService = (SupplierService) context.getBean("supplierService");
	}

	@Test
	public void saveSupplierTest() {			
		
		supplier.setName("LED");
		supplier.setAddress("Ahmedabad");						
		
		boolean flag = supplierService.save(supplier);
		
		Assert.assertEquals("save supplier test case", true, flag);
	}
	
	@Test
	public void getAllSuppliers() {
		List<Supplier> supplierList = supplierService.getAllSuppliers();
		System.out.println(supplierList);
	}

}