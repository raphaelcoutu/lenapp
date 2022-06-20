package com.raphaelcoutu.lenapp.controller;

import com.raphaelcoutu.lenapp.dto.*;
import com.raphaelcoutu.lenapp.entity.Account;
import com.raphaelcoutu.lenapp.entity.ProductTransaction;
import com.raphaelcoutu.lenapp.entity.Transaction;
import com.raphaelcoutu.lenapp.mapper.AccountMapper;
import com.raphaelcoutu.lenapp.mapper.ProductMapper;
import com.raphaelcoutu.lenapp.mapper.ProductTransactionMapper;
import com.raphaelcoutu.lenapp.mapper.TransactionMapper;
import com.raphaelcoutu.lenapp.service.AccountService;
import com.raphaelcoutu.lenapp.service.ProductService;
import com.raphaelcoutu.lenapp.service.ProductTransactionService;
import com.raphaelcoutu.lenapp.service.TransactionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/accounts")
@PreAuthorize("@accessController.checkAccess()")
public class AccountController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;

    private final ProductService productService;
    private final ProductMapper productMapper;

    private final TransactionService transactionService;
    private final TransactionMapper transactionMapper;

    private final ProductTransactionService ptService;
    private final ProductTransactionMapper ptMapper;

    public AccountController(AccountService accountService,
                             AccountMapper accountMapper,
                             ProductService productService,
                             ProductMapper productMapper,
                             TransactionService transactionService,
                             TransactionMapper transactionMapper,
                             ProductTransactionService ptService,
                             ProductTransactionMapper ptMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
        this.productService = productService;
        this.productMapper = productMapper;
        this.transactionService = transactionService;
        this.transactionMapper = transactionMapper;
        this.ptService = ptService;
        this.ptMapper = ptMapper;
    }

    @GetMapping
    public Iterable<AccountListDto> getAllAccounts() {
        Iterable<Account> accounts = accountService.getAll();
        return accountMapper.entitiesToListDto(accounts);
    }

    @GetMapping("/{id}")
    public AccountDto getAccount(@PathVariable Long id) {
        return accountMapper.entityToDto(accountService.get(id));
    }

    @GetMapping("/{id}/products")
    public Iterable<ProductListDto> getAccountProducts(@PathVariable Long id) {
        return productMapper.entitiesToListDto(productService.getProductsByAccountId(id));
    }

    @GetMapping("/{id}/transactions")
    public Iterable<TransactionListDto> getAccountTransactions(@PathVariable Long id) {
        Iterable<Transaction> transactions = transactionService.getProductsByAccountId(id);
        return transactionMapper.entitiesToListDto(transactions);
    }

    @GetMapping("/{id}/productTransactions")
    public Iterable<ProductTransactionListDto> getAccountProductTransactions(@PathVariable Long id) {
        Iterable<ProductTransaction> pTransactions = ptService.getProductTransactionsByAccountId(id);
        return ptMapper.entitiesToListDto(pTransactions);
    }
}
