package com.raphaelcoutu.lenapp.repository;

import com.raphaelcoutu.lenapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Iterable<Product> findProductsByAccountId(Long id);
}
