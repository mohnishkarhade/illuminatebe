package com.niit.illuminatebe.dao;

import java.util.List;

import com.niit.illuminatebe.model.Customer;

public interface CustomerDao {

	public List<Customer> getAllCustomers();

	public boolean save(Customer customer);

	public boolean update(Customer customer);

	public boolean delete(int id);

	public Customer getUserById(int id);

	public Customer getUserByUserName(String username);

}
