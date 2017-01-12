package com.matex.app.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.matex.app.model.Transaction;
import com.matex.app.model.to.TransactionTo;

@Component
public class TransactionMapper {
	@Autowired
	UsersMapper userMapper;
	

	public TransactionTo mapModel2To(Transaction Transaction) {
		return new TransactionTo(userMapper.mapModel2To(Transaction.getDebtor()), userMapper.mapModel2To(Transaction.getCreditor()), Transaction.getDebt());
	}

	public Transaction mapTo2Model(TransactionTo TransactionTo) {
		return new Transaction(userMapper.mapTo2Model(TransactionTo.getDebtor()),userMapper.mapTo2Model(TransactionTo.getCreditor()), TransactionTo.getDebt());
	}
	public List<TransactionTo> mapModels2Tos(List<Transaction> Transactions) {
		List<TransactionTo> TransactionsTo = new ArrayList<TransactionTo>();
		for (Transaction Transaction : Transactions) {
			TransactionsTo.add(new TransactionTo(userMapper.mapModel2To(Transaction.getDebtor()), userMapper.mapModel2To(Transaction.getCreditor()), Transaction.getDebt()));
		}
	    return TransactionsTo;
	  }

	  public List<Transaction> mapTos2Models(List<TransactionTo> TransactionTos) {
		  List<Transaction> Transactions = new ArrayList<Transaction>();
			for (TransactionTo Transaction : TransactionTos) {
				Transactions.add(new Transaction(userMapper.mapTo2Model(Transaction.getDebtor()), userMapper.mapTo2Model(Transaction.getCreditor()),Transaction.getDebt()));
			}
		    return Transactions;
	  }
}
