package com.niit.illuminatebe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.niit.illuminatebe.model.Users;

@Service
public interface UsersService {
	public List<Users> getAllUsers();

	public boolean save(Users users);

	public boolean update(Users users);

	public boolean delete(int id);

	public Users getUserById(int id);

	public Users getUserByUserName(String username);
}
