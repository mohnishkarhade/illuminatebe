package com.niit.illuminatebe.dao;

import java.util.List;

import com.niit.illuminatebe.model.Customer;
import com.niit.illuminatebe.model.Users;

public interface CustomerDao {

	public List<Customer> getAllCustomers();

	public boolean save(Customer customer);

	public boolean update(Customer customer);

	public boolean delete(int id);

	public Customer getUserById(int id);

	public Users getUsersById(int id);

	public Customer getUserByUserName(String username);

	public Customer getUserByCustomerName(String name);

	public String getUserRole(String username);

	public boolean getStatus(int id);

	public int changeStatus(int id);

}
