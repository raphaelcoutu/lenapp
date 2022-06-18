package com.raphaelcoutu.lenapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private String confirmationNumber;

    @OneToMany(mappedBy = "transaction")
    private Set<ProductTransaction> products;
}
