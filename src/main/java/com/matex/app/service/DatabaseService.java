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
import com.matex.app.model.DTO.TransactionDTO;
import com.matex.app.model.DTO.UserDTO;


@Service
public class DatabaseService {
	@Autowired
	UsersDAO usersDAO;	
	@Autowired
	TransactionDAO transactionDAO;
	@Autowired
	RoleDAO roleDAO;
	
	public DatabaseService()
	{
		
	}
	public String saveUser(UserDTO user)
	{
		User users = UsersMapper.INSTANCE.userDTOToUser(user);
		Role userRole = roleDAO.findByName("ROLE_USER");
		users.setRole(Arrays.asList(userRole));
		usersDAO.save(users);
		return "Object saved to database";
	}
	public List<TransactionDTO> getAllTransactions()
	{
		List<Transaction> transaction = new ArrayList<Transaction>();
		transactionDAO.findAll().forEach(transaction::add);
		removePassword(transaction);
		return TransactionMapper.INSTANCE.transactionsToTransactionDtos(transaction);
	}
	public String saveTransaction(TransactionDTO transactionTo)
	{
		transactionDAO.save(TransactionMapper.INSTANCE.transactionDTOToTransaction(transactionTo));
		return "Object saved to database";
	}
	public String deleteTransaction(TransactionDTO transactionTo)
	{
		transactionDAO.delete(TransactionMapper.INSTANCE.transactionDTOToTransaction(transactionTo));
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
