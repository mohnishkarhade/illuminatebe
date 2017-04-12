package com.niit.illuminatebe.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.illuminatebe.dao.CustomerOrderDao;
import com.niit.illuminatebe.model.CustomerOrder;
import com.niit.illuminatebe.service.CustomerOrderService;

@Service("customerOrderService")
@Transactional
public class CustomerOrderServiceImpl implements CustomerOrderService {

	@Autowired
	private CustomerOrderDao customerOrderDao;

	@Override
	public boolean addCustomerOrder(CustomerOrder customerOrder) {
		// TODO Auto-generated method stub
		return customerOrderDao.addCustomerOrder(customerOrder);
	}

	@Override
	public List<CustomerOrder> getAllOrders() {
		// TODO Auto-generated method stub
		return customerOrderDao.getAllOrders();
	}

	@Override
	public CustomerOrder getCustomerOrderById(int id) {
		// TODO Auto-generated method stub
		return customerOrderDao.getCustomerOrderById(id);
	}

	@Override
	public int changeOrderStatus(int id, String status) {
		// TODO Auto-generated method stub
		return customerOrderDao.changeOrderStatus(id, status);
	}

}
