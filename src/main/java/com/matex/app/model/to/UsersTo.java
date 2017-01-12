package com.matex.app.model.to;

public class UsersTo {

	private String username;

	private String password;

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
	public UsersTo(String username, String password, boolean enabled)
	{
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}
	public UsersTo()
	{
		
	}
}
