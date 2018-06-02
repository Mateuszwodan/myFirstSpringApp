package com.matex.app.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class User {
	
	@NotNull
	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@NotNull
	private String password;

	@NotNull
	private boolean enabled;
	
	 @ManyToMany(fetch=FetchType.EAGER)
	    @JoinTable( 
	        name = "users_groups", 
	        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "Id"), 
	        inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "Id")) 
	    private Collection<Groups> groups;
	 
	 @ManyToMany
	 @Fetch(value = FetchMode.SUBSELECT)
	    @JoinTable( 
	        name = "users_roles", 
	        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "Id"), 
	        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")) 
	    private Collection<Role> roles;
	
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
	

	public User()
	{
		
	}
	public User(String name, String password, boolean enabled, Collection<Groups> groups, Collection<Role> roles) {
		super();
		this.setName(name);
		this.password = password;
		this.enabled = enabled;
		this.setGroups(groups);
		this.roles = roles;
	}

	 public void setRole(Collection<Role> roles)
	 {
		 this.roles = roles;
	 }
	 public Collection<Role> getRoles()
	 {
		 return roles;
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
