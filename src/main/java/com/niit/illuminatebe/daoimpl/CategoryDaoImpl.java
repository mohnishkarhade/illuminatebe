package com.niit.illuminatebe.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.illuminatebe.dao.CategoryDao;
import com.niit.illuminatebe.model.Category;

@Repository()
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	public boolean save(Category category) {
		// TODO Auto-generated method stub
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
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}

}
