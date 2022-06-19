package com.raphaelcoutu.lenapp.service;

import com.raphaelcoutu.lenapp.entity.Account;
import com.raphaelcoutu.lenapp.exception.ResourceNotFoundException;
import com.raphaelcoutu.lenapp.mapper.AccountMapper;
import com.raphaelcoutu.lenapp.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
    }

    public Iterable<Account> getAll() {
        return accountRepository.findAll();
    }

    public Account get(Long id) {
        return accountRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}
