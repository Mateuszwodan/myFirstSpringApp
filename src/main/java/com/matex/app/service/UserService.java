package com.matex.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matex.app.database.DAO.UsersDAO;
import com.matex.app.mapper.UsersMapper;
import com.matex.app.model.User;
import com.matex.app.model.DTO.UserDTO;

@Service
public class UserService {

	@Autowired
	UsersDAO usersDAO;	
	
	public UserService(UsersDAO usersDAO)
	{
		this.usersDAO = usersDAO;
	}
	public UserDTO getUserByUsername(String username)
	{
		User user = usersDAO.findByName(username);
		UserDTO usersTo = UsersMapper.INSTANCE.userToUserDto(user);
		usersTo.setPassword("");
		return usersTo;
	}
	public List<User> getAll()
	{
		List<User> users = new ArrayList<User>();
    	usersDAO.findAll().forEach(users::add);
    	for (User users2 : users) {
			users2.setPassword("");
		}
    	return users;
	}
}
