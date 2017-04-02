package com.niit.illuminatebe.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.illuminatebe.dao.ProductDao;
import com.niit.illuminatebe.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	private final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		logger.info("Starting getAllProducts method");
		try {
			List<Product> productList = sessionFactory.getCurrentSession().createQuery("from Product").list();
			for (Product c : productList) {
				logger.info("Product List:: " + c);
			}
			logger.info("Ending getAllProducts method");
			return productList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Exception occured" + e);
			throw e;
		}
	}

	@Override
	public boolean save(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Exception occured" + e);
			return false;
		}
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Exception occured" + e);
			throw e;
		}
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(getProductByID(id));
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Exception occured" + e);
			throw e;
		}
	}

	@Override
	public Product getProductByID(int id) {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().get(Product.class, id);
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Exception occured" + e);
			throw e;
		}
	}

	@Override
	public Product getProductByName(String name) {
		// TODO Auto-generated method stub
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from Product where name= '" + name + "'");
			Product product = (Product) query.uniqueResult();

			return product;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Exception occured" + e);
			throw e;
		}
	}

	@Override
	public List<Product> viewByStatus(String status) {
		// TODO Auto-generated method stub
		try {
			Query query = sessionFactory.getCurrentSession()
					.createQuery("from Product where status like '" + status + "'");
			List<Product> productList = query.list();

			return productList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.error("Exception occured" + e);
			throw e;
		}
	}

	@Override
	public boolean changeStatus(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
