package com.matex.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matex.app.database.DAO.ClientDAO;
import com.matex.app.database.DAO.TransactionDAO;
import com.matex.app.mapper.ClientMapper;
import com.matex.app.mapper.TransactionMapper;
import com.matex.app.model.Client;
import com.matex.app.model.Transaction;
import com.matex.app.model.Users;
import com.matex.app.model.to.ClientTo;
import com.matex.app.model.to.TransactionTo;

@Service
public class DatabaseService {
	@Autowired
	ClientDAO clientDAO;	
	@Autowired
	ClientMapper clientMapper;
	@Autowired
	TransactionDAO transactionDAO;
	@Autowired
	TransactionMapper transactionMapper;
	@Autowired
	public DatabaseService(ClientMapper clientMapper, ClientDAO clientDAO, TransactionDAO transactionDAO, TransactionMapper transactionMapper)
	{
		this.clientMapper = clientMapper;
		this.clientDAO = clientDAO;
		this.transactionDAO = transactionDAO;
		this.transactionMapper = transactionMapper;
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
	public List<TransactionTo> getAllTransactions()
	{
		List<Transaction> transaction = new ArrayList<Transaction>();
		transactionDAO.findAll().forEach(transaction::add);
		return transactionMapper.mapModels2Tos(transaction);
	}
	public String saveTransaction(TransactionTo transactionTo)
	{
		transactionDAO.save(transactionMapper.mapTo2Model(transactionTo));
		return "Object saved to database";
	}
}
