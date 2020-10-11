package ru.lidzhiev.bankaccountmanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "ACCOUNT")
public class Account {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private int amountOfMoney;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(int amount) {
        this.amountOfMoney = amount;
    }
}
