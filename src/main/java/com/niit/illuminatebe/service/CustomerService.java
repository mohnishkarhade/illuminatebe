package com.niit.illuminatebe.service;

import java.util.List;

import com.niit.illuminatebe.model.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomers();

	public boolean save(Customer customer);

	public boolean update(Customer customer);

	public boolean delete(int id);

	public Customer getUserById(int id);

	public Customer getUserByUserName(String username);
	
	public Customer getUserByCustomerName(String name);

	public String getUserRole(String username);
}
