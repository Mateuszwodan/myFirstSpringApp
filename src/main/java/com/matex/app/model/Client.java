package com.matex.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
	private long id;

	@NotNull
	@Getter
	@Setter
	private String email;

	@NotNull
	@Getter
	@Setter
	private String name;
	
	public Client()
	{}
	public Client(long id)
	{
		this.id = id;
	}
	public Client(String email, String name) {
		this.email = email;
		this.name = name;
	}

	public Client(String email) {
		this.email = email;
	}

}
