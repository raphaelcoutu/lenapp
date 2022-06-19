package com.raphaelcoutu.lenapp.service;

import com.raphaelcoutu.lenapp.entity.ProductTransaction;
import com.raphaelcoutu.lenapp.repository.ProductTransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductTransactionService {

    private final ProductTransactionRepository ptRepository;

    public ProductTransactionService(ProductTransactionRepository ptRepository) {
        this.ptRepository = ptRepository;
    }

    public Iterable<ProductTransaction> getProductTransactionsByAccountId(Long accountId) {
        return ptRepository.findProductTransactionsByAccountId(accountId);
    }
}
