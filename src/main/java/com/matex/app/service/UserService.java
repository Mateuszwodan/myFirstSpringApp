package com.matex.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matex.app.database.DAO.UsersDAO;
import com.matex.app.mapper.UsersMapper;
import com.matex.app.model.Users;
import com.matex.app.model.to.UsersTo;

@Service
public class UserService {

	@Autowired
	UsersDAO usersDAO;	
	@Autowired
	UsersMapper userMapper;
	
	public UserService(UsersDAO usersDAO)
	{
		this.usersDAO = usersDAO;
	}
	public UsersTo getUserByUsername(String username)
	{
		Users user = usersDAO.findByUsers(username);
		UsersTo usersTo = userMapper.mapModel2To(user);
		usersTo.setPassword("");
		return usersTo;
	}
	public List<Users> getAll()
	{
		List<Users> users = new ArrayList<Users>();
    	usersDAO.findAll().forEach(users::add);
    	for (Users users2 : users) {
			users2.setPassword("");
		}
    	return users;
	}
}
