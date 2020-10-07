package ru.lidzhiev.bankaccountmanager.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account {
    private int id;
    private int amount;

    public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }
}
