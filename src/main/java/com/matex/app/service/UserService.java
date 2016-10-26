package com.matex.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matex.app.database.DAO.UsersDAO;
import com.matex.app.model.Users;

@Service
public class UserService {

	@Autowired
	UsersDAO usersDAO;
	
	public UserService(UsersDAO usersDAO)
	{
		this.usersDAO = usersDAO;
	}
	public Users getUserByUsername(String username)
	{
		return usersDAO.findByUsername(username);
	}
}
