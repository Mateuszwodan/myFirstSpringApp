package com.matex.app.security;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.matex.app.model.Role;
import com.matex.app.model.User;

public class MyPrincipals implements UserDetails {
	
	User user;
	
	public MyPrincipals(User user)
	{
		this.user = user;
	}
	public MyPrincipals(String name, String pswd, boolean b, boolean c, boolean d, boolean isActive,
			Collection<Role> roles) {
		user = new User();
		user.setUsername(name);
		user.setPassword(pswd);
		user.setRole(roles);
	}
	Role role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
		Collection<Role> roles = user.getRoles();
		for (Role role : roles) {
			auths.add(new SimpleGrantedAuthority(role.getName()));
		}		
		return auths;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
