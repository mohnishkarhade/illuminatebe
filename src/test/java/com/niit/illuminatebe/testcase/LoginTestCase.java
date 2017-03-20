package com.niit.illuminatebe.testcase;

import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.illuminatebe.config.ApplicationContextConfig;
import com.niit.illuminatebe.model.Users;
import com.niit.illuminatebe.service.UsersService;


public class LoginTestCase {

	@Autowired
	private static Users users;

	@Autowired
	private static UsersService usersService;

	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ApplicationContextConfig.class);

		users = (Users) context.getBean("users");
		usersService = (UsersService) context.getBean("usersService");
	}

//	@Test
//	public void loginTest() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter username:");
//		String un = sc.nextLine();		
//		System.out.println("Enter password:");
//		String pwd = sc.nextLine();
//		sc.close();
//		users = usersService.getUserByUserName(un);
//
//		if (users != null) {
//			if (un.equalsIgnoreCase(users.getUsername()) && pwd.equals(users.getPassword())) {
//				System.out.println("Successfully logged in");
//			} else{
//				System.err.println("Wrong password");
//			}
//		} else {
//			System.err.println("Usrename not found");
//		}
//
//	}
}
