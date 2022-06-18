package com.raphaelcoutu.lenapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lotNumber;

    private LocalDate expirationDate;

    private Integer balance;

    @OneToMany(mappedBy = "product")
    private Set<ProductTransaction> transactions;
}
