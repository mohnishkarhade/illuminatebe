package com.niit.illuminatebe.serviceimpl;

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
	public void addCustomerOrder(CustomerOrder customerOrder) {
		// TODO Auto-generated method stub
		customerOrderDao.addCustomerOrder(customerOrder);
	}

}
