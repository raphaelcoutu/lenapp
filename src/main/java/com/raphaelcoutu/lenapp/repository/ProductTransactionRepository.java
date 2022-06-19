package com.raphaelcoutu.lenapp.repository;

import com.raphaelcoutu.lenapp.entity.ProductTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTransactionRepository extends JpaRepository<ProductTransaction, Long> {
    @Query("""
    select pt from ProductTransaction pt
    left join pt.product p
    left join pt.transaction t
    where p.account.id = :accountId
    """)
    Iterable<ProductTransaction> findProductTransactionsByAccountId(Long accountId);
}
