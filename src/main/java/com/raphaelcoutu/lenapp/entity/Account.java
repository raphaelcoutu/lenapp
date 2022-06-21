package com.raphaelcoutu.lenapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long balance;

    @OneToMany(mappedBy = "account")
    private List<Product> products;

    public Account() {
    }

    public Account(Long id, String name, Long balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
}
