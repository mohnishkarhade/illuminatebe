package com.niit.illuminatebe.testcase;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.illuminatebe.config.ApplicationContextConfig;
import com.niit.illuminatebe.model.BillingAddress;
import com.niit.illuminatebe.model.ShippingAddress;
import com.niit.illuminatebe.model.Users;
import com.niit.illuminatebe.service.UsersService;

import junit.framework.Assert;

public class UsersTestCase {

	// @Test
	// @Before -> If you want to call any method before executing each and every
	// testcase
	// @BeforeClass -> Like static - execute only once - before executing first
	// testcase

	// @After -> If you want to call any method after executing each and every
	// testcase
	// @AfterClass -> Like static - execute only once - after executing all
	// testcases

	@Autowired
	private static Users users;

	@Autowired
	private static BillingAddress billingAddress;

	@Autowired
	private static ShippingAddress shippingAddress;

	@Autowired
	private static UsersService usersService;

	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ApplicationContextConfig.class);

		// context.scan("com.niit");
		// context.refresh();

		users = (Users) context.getBean("users");
		usersService = (UsersService) context.getBean("usersService");
		billingAddress = (BillingAddress) context.getBean("billingAddress");
		shippingAddress = (ShippingAddress) context.getBean("shippingAddress");

	}

	@Test
	public void registerUsersTestCase() {
		users.setName("John Doe");
		users.setUsername("johndoe");
		users.setPassword("123");
		users.setEmail("john@gmail.com");
		users.setMobileno("9899999999");
		billingAddress.setStreetName("cg road");
		billingAddress.setApartNo("123");
		billingAddress.setCity("ahmedabad");
		billingAddress.setState("Gujarat");
		billingAddress.setCountry("India");
		billingAddress.setZipcode(380012);

		shippingAddress.setStreetName("cg road");
		shippingAddress.setApartNo("123");
		shippingAddress.setCity("ahmedabad");
		shippingAddress.setState("Gujarat");
		shippingAddress.setCountry("India");
		shippingAddress.setZipcode(380012);

		users.setBillingAddress(billingAddress);
		users.setShippingAddress(shippingAddress);

		boolean flag = usersService.save(users);

		// compare you are expecting v/s what you are getting from this method
		// here save()

		Assert.assertEquals("register users test case", true, flag);
	}

	@Test
	public void listUsersTestCase() {
		List<Users> result = usersService.getAllUsers();
		System.out.println(result + "\n");
	}
	// @Test
	// public void deleteUser(){
	// boolean flag = usersServices.delete(users.getId()-1);
	// Assert.assertEquals("delete user test case", true, flag);
	// }

	// @Test
	// public void getUserById(){
	// Users user = usersService.getUserById(28);
	// System.out.println(user.toString());
	// }
}
