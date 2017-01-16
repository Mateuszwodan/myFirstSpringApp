package com.matex.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matex.app.database.DAO.RoleDAO;
import com.matex.app.database.DAO.TransactionDAO;
import com.matex.app.database.DAO.UsersDAO;
import com.matex.app.mapper.TransactionMapper;
import com.matex.app.mapper.UsersMapper;
import com.matex.app.model.Role;
import com.matex.app.model.Transaction;
import com.matex.app.model.User;
import com.matex.app.model.to.TransactionTo;
import com.matex.app.model.to.UsersTo;
import com.mysql.fabric.xmlrpc.base.Array;


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
	RoleDAO roleDAO;
	@Autowired
	public DatabaseService(UsersMapper usersMapper, UsersDAO clientDAO, TransactionDAO transactionDAO, TransactionMapper transactionMapper, RoleDAO roleDAO)
	{
		this.UsersMapper = usersMapper;
		this.usersDAO = clientDAO;
		this.transactionDAO = transactionDAO;
		this.transactionMapper = transactionMapper;
		this.roleDAO = roleDAO;
	}
	public String saveUser(UsersTo user)
	{
		User users = UsersMapper.mapTo2Model(user);
		Role userRole = roleDAO.findByName("ROLE_USER");
		users.setRole(Arrays.asList(userRole));
		usersDAO.save(users);
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
