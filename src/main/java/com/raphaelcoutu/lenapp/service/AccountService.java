package com.raphaelcoutu.lenapp.service;

import com.raphaelcoutu.lenapp.entity.Account;
import com.raphaelcoutu.lenapp.entity.Product;
import com.raphaelcoutu.lenapp.entity.ProductTransaction;
import com.raphaelcoutu.lenapp.entity.Transaction;
import com.raphaelcoutu.lenapp.repository.AccountRepository;
import com.raphaelcoutu.lenapp.repository.ProductRepository;
import com.raphaelcoutu.lenapp.repository.ProductTransactionRepository;
import com.raphaelcoutu.lenapp.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final ProductRepository productRepository;
    private final TransactionRepository transactionRepository;
    private final ProductTransactionRepository ptRepository;

    public Iterable<Account> getAll() {
        return accountRepository.findAll();
    }

    public Account get(Long id) {
        return accountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Iterable<Product> getProductsByAccountId(Long id) {
        return productRepository.findProductsByAccountId(id);
    }

    public Iterable<Transaction> getTransactionsByAccountId(Long id) {
        return transactionRepository.findTransactionsByAccountId(id);
    }

    public Iterable<ProductTransaction> getProductTransactionsByAccountId(Long id) {
        return ptRepository.findProductTransactionsByAccountId(id);
    }
}
