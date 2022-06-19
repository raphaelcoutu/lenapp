package com.raphaelcoutu.lenapp.service;

import com.raphaelcoutu.lenapp.entity.Transaction;
import com.raphaelcoutu.lenapp.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Iterable<Transaction> getProductsByAccountId(Long accountId) {
        return transactionRepository.findTransactionsByAccountId(accountId);
    }

}
