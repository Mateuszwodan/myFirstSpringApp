package com.matex.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matex.app.database.DAO.TransactionDAO;
import com.matex.app.database.DAO.UsersDAO;
import com.matex.app.mapper.ClientMapper;
import com.matex.app.mapper.TransactionMapper;
import com.matex.app.mapper.UsersMapper;
import com.matex.app.model.Client;
import com.matex.app.model.Transaction;
import com.matex.app.model.to.ClientTo;
import com.matex.app.model.to.TransactionTo;
import com.matex.app.model.to.UsersTo;


@Service
public class DatabaseService {
	@Autowired
	UsersDAO usersDAO;	
	@Autowired
	UsersMapper UsersMapper;
	@Autowired
	TransactionDAO transactionDAO;
	@Autowired
	TransactionMapper transactionMapper;
	@Autowired
	public DatabaseService(UsersMapper usersMapper, UsersDAO clientDAO, TransactionDAO transactionDAO, TransactionMapper transactionMapper)
	{
		this.UsersMapper = usersMapper;
		this.usersDAO = clientDAO;
		this.transactionDAO = transactionDAO;
		this.transactionMapper = transactionMapper;
	}
	public String saveUser(UsersTo user)
	{
		usersDAO.save(UsersMapper.mapTo2Model(user));
		return "Object saved to database";
	}
	public List<TransactionTo> getAllTransactions()
	{
		List<Transaction> transaction = new ArrayList<Transaction>();
		transactionDAO.findAll().forEach(transaction::add);
		removePassword(transaction);
		return transactionMapper.mapModels2Tos(transaction);
	}
	public String saveTransaction(TransactionTo transactionTo)
	{
		transactionDAO.save(transactionMapper.mapTo2Model(transactionTo));
		return "Object saved to database";
	}
	public String deleteTransaction(TransactionTo transactionTo)
	{
		transactionDAO.delete(transactionMapper.mapTo2Model(transactionTo));
		return "Object deleted from database";
	}
	private void removePassword(List<Transaction> transactions)
	{
		for (Transaction transaction : transactions) {
			transaction.getCreditor().setPassword("");
			transaction.getDebtor().setPassword("");
		}
	}
}
