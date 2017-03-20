package com.niit.illuminatebe.service;

import java.util.List;

import com.niit.illuminatebe.model.Users;

public interface UsersService {
	public List<Users> getAllUsers();

	public boolean save(Users users);

	public boolean update(Users users);

	public boolean delete(int id);

	public Users getUserById(int id);

	public Users getUserByUserName(String username);
}
