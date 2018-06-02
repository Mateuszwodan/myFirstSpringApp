package com.matex.app.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.matex.app.model.Transaction;
import com.matex.app.model.DTO.TransactionDTO;

@Mapper
public interface TransactionMapper {
	TransactionMapper INSTANCE = Mappers.getMapper( TransactionMapper.class );
	 
    TransactionDTO transactionToTransactionDto(Transaction transaction); 
    Transaction transactionDTOToTransaction(TransactionDTO transaction); 
    List<Transaction> transactionDTOsToTransactions(List<TransactionDTO> transaction); 
    List<TransactionDTO> transactionsToTransactionDtos(List<Transaction> transaction); 
}
