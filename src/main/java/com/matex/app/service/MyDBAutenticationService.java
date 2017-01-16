package com.matex.app.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
		User users = usersDAO.findByUsers(username);
		MyPrincipals myPrincipals = new MyPrincipals(users);	
		return generateUser(users.getUsername(), users.getPassword(), users.getEnabled(),users.getRoles());
	}
	private MyPrincipals generateUser(String name, String pswd, boolean isActive, Collection<Role> roles) {
		return new MyPrincipals(name, pswd, true, true, true, isActive, roles);
	}

}

