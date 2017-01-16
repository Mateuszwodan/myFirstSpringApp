package com.matex.app.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Privilege {
	 public Privilege(String name) {
		this.setName(name);
	}
	 public Privilege()
	 {
		 
	 }

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	 
	    private String name;
	 
	    @ManyToMany(mappedBy = "privileges")
	    private Collection<Role> roles;
	    
	    public Collection<Role> getRole()
	    {
	    	return roles;
	    }
}
