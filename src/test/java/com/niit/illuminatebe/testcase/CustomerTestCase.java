package com.niit.illuminatebe.testcase;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.illuminatebe.config.ApplicationContextConfig;
import com.niit.illuminatebe.model.BillingAddress;
import com.niit.illuminatebe.model.Customer;
import com.niit.illuminatebe.model.ShippingAddress;
import com.niit.illuminatebe.service.CustomerService;

import junit.framework.Assert;

public class CustomerTestCase {

	@Autowired
	private static Customer customer;

	@Autowired
	private static CustomerService customerService;

	@Autowired
	private static BillingAddress billingAddress;

	@Autowired
	private static ShippingAddress shippingAddress;

	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ApplicationContextConfig.class);

		customer = (Customer) context.getBean("customer");
		customerService = (CustomerService) context.getBean("customerService");
		billingAddress = (BillingAddress) context.getBean("billingAddress");
		shippingAddress = (ShippingAddress) context.getBean("shippingAddress");
	}

	@Test
	public void saveCategoryTest() {
		customer.setName("LED");
		customer.setEmail("sas@kas.com");
		customer.setMobileno("6456454");
		customer.setUsername("mslas");
		customer.setPassword("asjka");
		billingAddress.setApartNo("123");
		billingAddress.setCity("ahsja");
		billingAddress.setStreetName("asj");
		billingAddress.setState("asgh");
		billingAddress.setCountry("ahsja");
		billingAddress.setZipcode(5654);
		shippingAddress.setApartNo("123");
		shippingAddress.setCity("ahsja");
		shippingAddress.setStreetName("asj");
		shippingAddress.setState("asgh");
		shippingAddress.setCountry("ahsja");
		shippingAddress.setZipcode(5654);

		customer.setBillingAddress(billingAddress);
		customer.setShippingAddress(shippingAddress);

		boolean flag = customerService.save(customer);

		Assert.assertEquals("save category test case", true, flag);
	}

}
