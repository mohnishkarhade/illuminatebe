package com.niit.illuminatebe.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.illuminatebe.dao.CustomerDao;
import com.niit.illuminatebe.model.Customer;
import com.niit.illuminatebe.model.Users;
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

	public Customer getUserByCustomerName(String name) {
		return customerDao.getUserByCustomerName(name);
	}

	@Override
	public String getUserRole(String username) {
		// TODO Auto-generated method stub
		return customerDao.getUserRole(username);
	}

	@Override
	public Users getUsersById(int id) {
		// TODO Auto-generated method stub
		return customerDao.getUsersById(id);
	}

	@Override
	public boolean getStatus(int id) {
		// TODO Auto-generated method stub
		return customerDao.getStatus(id);
	}

	@Override
	public int changeStatus(int id) {
		// TODO Auto-generated method stub
		return customerDao.changeStatus(id);
	}

}
