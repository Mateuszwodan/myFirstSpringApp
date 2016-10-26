package com.matex.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.matex.app.database.DAO.UsersDAO;
import com.matex.app.model.Users;

@Service
public class MyDBAutenticationService implements UserDetailsService {

	@Autowired
	UsersDAO usersDAO;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = usersDAO.findByUsername(username);
		List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
		List<String> roles = new ArrayList<String>();
		roles.add("ROLE_USER");
        if(roles!= null)  {
            for(String role: roles)  {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }     
		return generateUser(users.getUsername(), users.getPassword(), users.getEnabled(),grantList);
	}
	private User generateUser(String name, String pswd, boolean isActive, List<GrantedAuthority> roles) {
		return new User(name, pswd, true, true, true, isActive, roles);
	}

}
