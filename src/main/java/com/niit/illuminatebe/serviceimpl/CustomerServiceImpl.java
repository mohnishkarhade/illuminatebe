package com.niit.illuminatebe.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.illuminatebe.dao.CustomerDao;
import com.niit.illuminatebe.model.Customer;
import com.niit.illuminatebe.service.CustomerService;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerDao.getAllCustomers();
	}

	@Override
	public boolean save(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.save(customer);
	}

	@Override
	public boolean update(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.update(customer);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return customerDao.delete(id);
	}

	@Override
	public Customer getUserById(int id) {
		// TODO Auto-generated method stub
		return customerDao.getUserById(id);
	}

	@Override
	public Customer getUserByUserName(String username) {
		// TODO Auto-generated method stub
		return customerDao.getUserByUserName(username);
	}

	@Override
	public String getUserRole(String username) {
		// TODO Auto-generated method stub
		return customerDao.getUserRole(username);
	}

}
