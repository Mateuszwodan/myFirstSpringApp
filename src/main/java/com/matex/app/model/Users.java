package com.matex.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Users {
	
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
	public Users(String userID, String password)
	{
		this.users = userID;
		this.password = password;
	}

	public Users()
	{
		
	}
}
