package com.niit.illuminatebe.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.illuminatebe.dao.CustomerDao;
import com.niit.illuminatebe.model.Authorities;
import com.niit.illuminatebe.model.Customer;
import com.niit.illuminatebe.model.Users;

@Repository()
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	private final Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().createQuery("from Customer").list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean save(Customer customer) {

		logger.info("Starting method save() in CustomerDaoImpl");

		try {
			Session session = sessionFactory.getCurrentSession();

			customer.getBillingAddress().setCustomer(customer);
			customer.getShippingAddress().setCustomer(customer);

			session.saveOrUpdate(customer);
			session.saveOrUpdate(customer.getBillingAddress());
			session.saveOrUpdate(customer.getShippingAddress());

			logger.info("Customer details inserted");

			Authorities authorities = new Authorities();
			authorities.setAuthority("ROLE_USER");
			authorities.setUsername(customer.getUsername());
			session.saveOrUpdate(authorities);
			logger.info("User role assigned");

			Users users = new Users();
			users.setEnabled(true);
			users.setUsername(customer.getUsername());
			users.setPassword(customer.getPassword());
			users.setCustomer(customer);
			session.saveOrUpdate(users);
			customer.setUsers(users);
			session.saveOrUpdate(customer);
			logger.info("User detail inserted");

			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean update(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer getUserById(int id) {
		// TODO Auto-generated method stub
		try {
			return (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Customer getUserByUserName(String username) {
		// TODO Auto-generated method stub
		try {
			Query query = sessionFactory.getCurrentSession()
					.createQuery("from Customer where username= '" + username + "'");
			Customer customer = (Customer) query.uniqueResult();

			return customer;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public String getUserRole(String username) {
		// TODO Auto-generated method stub
		try {
			Query query = sessionFactory.getCurrentSession()
					.createQuery("from Authorities where username= '" + username + "'");
			Authorities authorities = (Authorities) query.uniqueResult();
			return authorities.getAuthority();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Customer getUserByCustomerName(String name) {
		// TODO Auto-generated method stub
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from Customer where name= '" + name + "'");
			Customer customer = (Customer) query.uniqueResult();

			return customer;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Users getUsersById(int id) {
		// TODO Auto-generated method stub
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("FROM Users where customerId=" + id);
			return (Users) query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	public boolean getStatus(int id) {
		Users users = getUsersById(id);
		return users.isEnabled();
	}

	@Override
	public int changeStatus(int id) {
		// TODO Auto-generated method stub
		try {
			Users users = getUsersById(id);
			boolean isEnable = users.isEnabled();

			if (isEnable) {
				Query query = sessionFactory.getCurrentSession()
						.createQuery("UPDATE Users SET enabled = " + false + " WHERE customerId = " + id);
				return query.executeUpdate();
			} else {
				Query query = sessionFactory.getCurrentSession()
						.createQuery("UPDATE Users SET enabled = " + true + " WHERE customerId = " + id);
				return query.executeUpdate();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

}
