package com.matex.app.database.DAO;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.matex.app.model.Transaction;
@Transactional
public interface TransactionDAO extends CrudRepository<Transaction, Long>{

}
