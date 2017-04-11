package com.niit.illuminatebe.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.illuminatebe.dao.CategoryDao;
import com.niit.illuminatebe.model.Category;

@Repository()
public class CategoryDaoImpl implements CategoryDao {
	
	private final Logger logger = LoggerFactory.getLogger(CategoryDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		logger.info("Starting getAllCategories method of categoryDao");
		try {
			List<Category> categoryList = sessionFactory.getCurrentSession().createQuery("from Category").list();
			
			return categoryList;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Exception occured"+e);
			throw e;
		}		
	}

	public boolean save(Category category) {
		// TODO Auto-generated method stub
		logger.info("Starting save method of categoryDao");
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Category category) {
		// TODO Auto-generated method stub
		logger.info("Starting update method of categoryDao");
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		logger.info("Starting delete method of categoryDao");
		try {
			sessionFactory.getCurrentSession().delete(getCategoryById(id));
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Category getCategoryById(int id) {
		// TODO Auto-generated method stub
		logger.info("Starting getCategoryById method of categoryDao");
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}

}
