package com.matex.app.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.matex.app.database.DAO.UsersDAO;
import com.matex.app.model.Role;
import com.matex.app.model.User;
import com.matex.app.security.MyPrincipals;

@Service
public class MyDBAutenticationService implements UserDetailsService {

	@Autowired
	UsersDAO usersDAO;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User users = usersDAO.findByName(username);
		MyPrincipals myPrincipals = new MyPrincipals(users);	
		return generateUser(users.getName(), users.getPassword(), users.getEnabled(),users.getRoles());
	}
	private MyPrincipals generateUser(String name, String pswd, boolean isActive, Collection<Role> roles) {
		return new MyPrincipals(name, pswd, true, true, true, isActive, roles);
	}

}

