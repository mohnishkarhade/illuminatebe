package com.niit.illuminatebe.dao;

import java.util.List;

import com.niit.illuminatebe.model.Users;

public interface UsersDao {
	
	public List<Users> getAllUsers();
	
	public boolean save(Users users);
	
	public boolean update(Users users);
	
	public boolean delete(int id);
	
	public Users getUserById(int id);
	
	public Users getUserByUserName(String username);
	
}
