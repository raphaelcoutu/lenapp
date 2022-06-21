package com.raphaelcoutu.lenapp.controller;

import com.raphaelcoutu.lenapp.entity.Account;
import com.raphaelcoutu.lenapp.mapper.AccountMapper;
import com.raphaelcoutu.lenapp.mapper.ProductMapper;
import com.raphaelcoutu.lenapp.mapper.ProductTransactionMapper;
import com.raphaelcoutu.lenapp.mapper.TransactionMapper;
import com.raphaelcoutu.lenapp.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountController.class)
class AccountControllerTest {
    @MockBean
    private AccountService accountService;

    @MockBean
    private AccountMapper accountMapper;

    @MockBean
    private ProductMapper productMapper;

    @MockBean
    private TransactionMapper transactionMapper;

    @MockBean
    ProductTransactionMapper productTransactionMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    void getAllAccounts() throws Exception {
        Account account1 = new Account(1L, "Account 1", 0L);
        Account account2 = new Account(2L, "Account 2", 28L);

        when(accountService.getAll()).thenReturn(List.of(account1, account2));

        mockMvc.perform(get("/api/accounts"))
                .andExpect(status().isOk());
    }
}