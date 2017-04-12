package com.niit.illuminatebe.service;

import java.util.List;

import com.niit.illuminatebe.model.CustomerOrder;

public interface CustomerOrderService {
	public boolean addCustomerOrder(CustomerOrder customerOrder);

	public List<CustomerOrder> getAllOrders();

	public CustomerOrder getCustomerOrderById(int id);

	public int changeOrderStatus(int id, String status);
}
