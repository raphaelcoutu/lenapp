package com.raphaelcoutu.lenapp.repository;

import com.raphaelcoutu.lenapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
