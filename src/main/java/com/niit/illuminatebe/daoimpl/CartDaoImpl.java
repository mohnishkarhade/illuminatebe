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
	public List<Cart> getCartList(int id) {
		// TODO Auto-generated method stub
		return null;
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
	public Long getTotalAmount(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart getCartByUsername(String username, String productname) {
		// TODO Auto-generated method stub
		try {
			logger.info("Starting getquantity method of cartdaoimpl");

			Query query = sessionFactory.getCurrentSession()
					.createQuery("from Cart WHERE username='" + username + "' and product_name='" + productname + "'");
			logger.info("Ending getquantity method of cartdaoimpl");
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
					+ username + "' and product_name='" + productname + "'");
			logger.info("Ending getquantity method of cartdaoimpl");
			return (int) query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Exception occured" + e);
			throw e;
		}
	}

}
