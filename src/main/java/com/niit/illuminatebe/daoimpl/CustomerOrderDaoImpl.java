	package com.niit.illuminatebe.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
		logger.info("Starting addCustomerOrder method of customerOrderDao");
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.getCurrentSession();

			Customer customer = customerOrder.getCustomer();
			customerOrder.setBillingAddress(customer.getBillingAddress());
			customerOrder.setShippingAddress(customer.getShippingAddress());
			customerOrder.setOrderStatus("Placed");
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

	public List<CustomerOrder> getAllOrders() {
		logger.info("Starting getAllOrders method of customerOrderDao");
		try {

			return sessionFactory.getCurrentSession().createQuery("FROM CustomerOrder").list();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Exception occured" + e);
			throw e;
		}
	}

	@Override
	public CustomerOrder getCustomerOrderById(int id) {
		// TODO Auto-generated method stub
		logger.info("Starting getCustomerOrderById method of customerOrderDao");
		return sessionFactory.getCurrentSession().get(CustomerOrder.class, id);
	}

	@Override
	public int changeOrderStatus(int id, String status) {
		// TODO Auto-generated method stub
		logger.info("Starting changeOrderStatus method of customerOrderDao");
		try {

			Query query = sessionFactory.getCurrentSession()
					.createQuery("UPDATE CustomerOrder SET orderStatus = '" + status + "' where id = " + id);
			return query.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Exception occured" + e);
			throw e;
		}
	}

}
