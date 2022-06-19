package com.raphaelcoutu.lenapp.repository;

import com.raphaelcoutu.lenapp.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("""
    select t from ProductTransaction pt
    left join pt.product p
    left join pt.transaction t
    where p.account.id = :accountId
    """)
    Iterable<Transaction> findTransactionsByAccountId(Long accountId);
}
