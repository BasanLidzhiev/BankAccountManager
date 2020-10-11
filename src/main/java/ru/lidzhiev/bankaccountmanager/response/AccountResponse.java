package ru.lidzhiev.bankaccountmanager.response;

import ru.lidzhiev.bankaccountmanager.entity.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountResponse {
    private List<Account> accounts = new ArrayList<>();
    String message;

    public AccountResponse() {
    }

    public AccountResponse(List<Account> accounts, String message) {
        this.accounts = accounts;
        this.message = message;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
