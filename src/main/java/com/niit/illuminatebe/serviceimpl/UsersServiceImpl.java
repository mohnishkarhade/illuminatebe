package com.niit.illuminatebe.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.illuminatebe.dao.UsersDao;
import com.niit.illuminatebe.model.Users;
import com.niit.illuminatebe.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDao usersDao;

	@Transactional
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return usersDao.getAllUsers();
	}
	
	@Transactional
	public boolean save(Users users) {
		// TODO Auto-generated method stub
		return usersDao.save(users);
	}
	
	@Transactional
	public boolean update(Users users) {
		// TODO Auto-generated method stub
		return usersDao.update(users);
	}

	@Transactional
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return usersDao.delete(id);
	}

	@Transactional
	public Users getUserById(int id) {
		// TODO Auto-generated method stub
		return usersDao.getUserById(id);
	}

	@Transactional
	public Users getUserByUserName(String username) {
		// TODO Auto-generated method stub
		return usersDao.getUserByUserName(username);
	}
}
