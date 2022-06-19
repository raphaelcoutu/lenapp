package com.raphaelcoutu.lenapp.service;

import com.raphaelcoutu.lenapp.entity.Product;
import com.raphaelcoutu.lenapp.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Iterable<Product> getProductsByAccountId(Long accountId) {
        return productRepository.findProductsByAccountId(accountId);
    }

}
