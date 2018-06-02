package com.matex.app.model.DTO;

import java.util.Collection;

import com.matex.app.model.Groups;
import com.matex.app.model.Role;

public class UserDTO {
	
	private Long Id;

	private String name;

	private String password;

	private boolean enabled;
	
	private Collection<Role> roles;
	
	private Collection<Groups> groups;
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
	}
	public String getPassword()
	{
		return password;
	}
	public boolean getEnabled()
	{
		return enabled;
	}
	public UserDTO()
	{
		
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	public Collection<Groups> getGroups() {
		return groups;
	}
	public void setGroups(Collection<Groups> groups) {
		this.groups = groups;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
}
