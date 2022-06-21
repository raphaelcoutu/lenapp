package com.raphaelcoutu.lenapp.service;

import com.raphaelcoutu.lenapp.repository.AccountRepository;
import com.raphaelcoutu.lenapp.repository.ProductRepository;
import com.raphaelcoutu.lenapp.repository.ProductTransactionRepository;
import com.raphaelcoutu.lenapp.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private ProductTransactionRepository ptRepository;

    @InjectMocks
    private AccountService cut;

    @Test
    void whenAccountDoesNotExist_throwsException() {
        when(accountRepository.findById(1L)).thenThrow(new EntityNotFoundException());

        assertThrows(EntityNotFoundException.class, () -> cut.get(1L));
    }

}