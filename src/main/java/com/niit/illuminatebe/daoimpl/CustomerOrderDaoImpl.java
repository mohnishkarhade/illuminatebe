package com.niit.illuminatebe.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.illuminatebe.dao.CustomerOrderDao;
import com.niit.illuminatebe.model.Customer;
import com.niit.illuminatebe.model.CustomerOrder;

@Repository
public class CustomerOrderDaoImpl implements CustomerOrderDao {

	private final Logger logger = LoggerFactory.getLogger(CustomerOrderDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addCustomerOrder(CustomerOrder customerOrder) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.getCurrentSession();

			Customer customer = customerOrder.getCustomer();
			customerOrder.setBillingAddress(customer.getBillingAddress());
			customerOrder.setShippingAddress(customer.getShippingAddress());
			session.saveOrUpdate(customerOrder);
			session.saveOrUpdate(customer);
			session.saveOrUpdate(customer.getBillingAddress());
			session.saveOrUpdate(customer.getShippingAddress());

			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Exception occured" + e);
			throw e;
		}
	}

}
