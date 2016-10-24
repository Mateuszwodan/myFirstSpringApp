package com.matex.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.matex.app.database.DAO.ClientDAO;
import com.matex.app.mapper.ClientMapper;
import com.matex.app.model.Client;
import com.matex.app.model.to.ClientTo;

public class DatabaseService {
	@Autowired
	ClientDAO clientDAO;	
	@Autowired
	ClientMapper clientMapper;
	@Autowired
	public DatabaseService(ClientMapper clientMapper, ClientDAO clientDAO)
	{
		this.clientMapper = clientMapper;
		this.clientDAO = clientDAO;
	}
	public String saveUser(ClientTo client)
	{
		clientDAO.save(clientMapper.mapTo2Model(client));
		return "Object saved to database";
	}
	public List<ClientTo> getAllUsers()
	{
		List<Client> clients = new ArrayList<Client>();
		clientDAO.findAll().forEach(clients::add);
		return clientMapper.mapModels2Tos(clients);
	}
}
