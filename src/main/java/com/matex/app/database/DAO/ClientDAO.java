package com.matex.app.database.DAO;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.matex.app.model.Client;

@Transactional
public interface ClientDAO extends CrudRepository<Client, Long>{

	public Client findByEmail(String email);
}
