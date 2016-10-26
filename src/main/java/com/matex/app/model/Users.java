package com.matex.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Users {
	
	@Id
	@NotNull
	private String username;

	@NotNull
	private String password;

	@NotNull
	private boolean enabled;
	
	public void setUsername(String username)
	{
		this.username = username;
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
		return username;
	}
	public String getPassword()
	{
		return password;
	}
	public boolean getEnabled()
	{
		return enabled;
	}

}
