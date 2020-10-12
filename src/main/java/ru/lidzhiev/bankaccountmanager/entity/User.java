package ru.lidzhiev.bankaccountmanager.entity;

import lombok.Data;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "USER")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String name;
    private String lastName;
    @OneToMany
    private List<Account> accounts;
}
