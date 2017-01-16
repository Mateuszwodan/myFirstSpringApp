package com.matex.app.model;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.Hibernate;

@Entity
public class User {
	
	@Id
	@NotNull
	private String users;

	@NotNull
	private String password;

	@NotNull
	private boolean enabled;
	
	public void setUsername(String username)
	{
		this.users = username;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}
	public String getUsername()
	{
		return users;
	}
	public String getPassword()
	{
		return password;
	}
	public boolean getEnabled()
	{
		return enabled;
	}
	public User(String userID, String password, boolean enabled)
	{
		this.users = userID;
		this.password = password;
		this.enabled = enabled;
	}
	

	public User()
	{
		
	}
	 @ManyToMany(fetch=FetchType.EAGER)
	    @JoinTable( 
	        name = "users_roles", 
	        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "users"), 
	        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")) 
	    private Collection<Role> roles;
	 public void setRole(Collection<Role> roles)
	 {
		 this.roles = roles;
	 }
	 public Collection<Role> getRoles()
	 {
		 return roles;
	 }
}
