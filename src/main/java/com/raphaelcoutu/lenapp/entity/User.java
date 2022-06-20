package com.raphaelcoutu.lenapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;
    private String username;

    public User() {}

    public User(UUID id, String username) {
        this.id = id;
        this.username = username;
    }
}
