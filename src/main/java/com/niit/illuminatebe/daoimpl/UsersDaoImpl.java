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

import com.niit.illuminatebe.dao.UsersDao;
import com.niit.illuminatebe.model.Authorities;
import com.niit.illuminatebe.model.Users;

@Repository
public class UsersDaoImpl implements UsersDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private final Logger logger = LoggerFactory.getLogger(UsersDaoImpl.class);

	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub

		// convert the hibernate query into db specific query language
		return sessionFactory.getCurrentSession().createQuery("from Users").list();
	}

	public boolean save(Users users) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.getCurrentSession();
			
			users.getBillingAddress().setUsers(users);
			users.getShippingAddress().setUsers(users);
			
			session.saveOrUpdate(users);
			session.saveOrUpdate(users.getBillingAddress());
			session.saveOrUpdate(users.getShippingAddress());
			
			logger.info("Users details inserted");

			Authorities authority = new Authorities();
			authority.setAuthority("ROLE_USER");
			authority.setUsername(users.getUsername());
			session.saveOrUpdate(authority);
			logger.info("User role assigned");
			
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Users users) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(users);
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
			sessionFactory.getCurrentSession().delete(getUserById(id));
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Users getUserById(int id) {
		// TODO Auto-generated method stub
		return (Users) sessionFactory.getCurrentSession().get(Users.class, id);
		// or you can query result like this ->
		// return (Users) sessionFactory.getCurrentSession().createQuery("from
		// Users where id ='"+id+"'").uniqueResult();
	}

	public Users getUserByUserName(String username) {
		// TODO Auto-generated method stub

		Query query = sessionFactory.getCurrentSession().createQuery("from Users where username= '" + username + "'");
		Users user = (Users) query.uniqueResult();

		return user;
	}

}
