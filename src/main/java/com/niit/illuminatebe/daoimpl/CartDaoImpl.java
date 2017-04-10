package com.niit.illuminatebe.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.illuminatebe.dao.CartDao;
import com.niit.illuminatebe.model.Cart;

@Repository
public class CartDaoImpl implements CartDao {

	private final Logger logger = LoggerFactory.getLogger(CartDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Cart> getCartList(String username) {
		try {
			Query query = sessionFactory.getCurrentSession()
					.createQuery("from Cart where username = '" + username + "' and status='NEW'");
			return query.list();
		} catch (Exception e) {
			logger.error("Exception occured" + e);
			throw e;
		}
	}

	@Override
	public boolean save(Cart cart) {
		// TODO Auto-generated method stub
		logger.info("Starting save method of cartdaoimpl");
		try {
			sessionFactory.getCurrentSession().save(cart);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Exception occured" + e);
			throw e;
		}
	}

	@Override
	public boolean delete(Cart cart) {
		// TODO Auto-generated method stub
		logger.info("Starting delete method of cartdaoimpl");
		try {
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Exception occured" + e);
			throw e;
		}
	}

	@Override
	public boolean update(Cart cart) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Exception occured" + e);
			throw e;
		}
	}

	@Override
	public long getTotalAmount(String username) {
		// TODO Auto-generated method stub
		try {

			Query query = sessionFactory.getCurrentSession().createQuery(
					"SELECT SUM(price*quantity) FROM Cart where username='" + username + "' and status = 'NEW'");
			if (query.uniqueResult() == null) {
				return 0;
			} else {
				long result = (long) query.uniqueResult();
				return result;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Exception occured" + e);
			throw e;
		}
	}

	@Override
	public Cart getCartByUsername(String username, String productname) {
		// TODO Auto-generated method stub
		try {
			logger.info("Starting getcartbyusername method of cartdaoimpl");

			Query query = sessionFactory.getCurrentSession().createQuery("from Cart WHERE username='" + username
					+ "' and product_name='" + productname + "' and status = 'NEW'");
			logger.info("Ending getcartbyusername method of cartdaoimpl");
			return (Cart) query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Exception occured" + e);
			throw e;
		}
	}

	@Override
	public int getQuantity(String username, String productname) {
		// TODO Auto-generated method stub
		try {
			logger.info("Starting getquantity method of cartdaoimpl");

			Query query = sessionFactory.getCurrentSession().createQuery("SELECT quantity from Cart WHERE username='"
					+ username + "' and product_name='" + productname + "' and status = 'NEW'");
			logger.info("Ending getquantity method of cartdaoimpl");
			return (int) query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Exception occured" + e);
			throw e;
		}
	}

	@Override
	public long getNumberOfProducts(String username) {
		// TODO Auto-generated method stub
		try {
			Query query = sessionFactory.getCurrentSession()
					.createQuery("SELECT SUM(quantity) FROM Cart where username='" + username + "' and status = 'NEW'");
			if (query.uniqueResult() == null) {
				return 0;
			} else {
				long result = (long) query.uniqueResult();
				return result;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Exception occured" + e);
			throw e;
		}
	}

	@Override
	public Cart getCartById(int id) {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().get(Cart.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Exception occured" + e);
			throw e;
		}
	}

}
