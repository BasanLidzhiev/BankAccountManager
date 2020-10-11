package ru.lidzhiev.bankaccountmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.lidzhiev.bankaccountmanager.entity.Account;
import ru.lidzhiev.bankaccountmanager.repository.AccountRepository;
import ru.lidzhiev.bankaccountmanager.request.PutAndWithdrawMoneyRequest;
import ru.lidzhiev.bankaccountmanager.request.TransferRequest;
import ru.lidzhiev.bankaccountmanager.response.AccountResponse;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountRepository repository;

    @GetMapping("/transferMoney")
    public AccountResponse transferMoney(@RequestBody TransferRequest request) {
        AccountResponse response = new AccountResponse();
        repository.addSumToAmount(request.getIdFrom(), request.getSum());
        repository.subtractSumFromAmount(request.getIdTo(), request.getSum());
        response.getAccounts().add(repository.findById(request.getIdFrom()).get());
        response.getAccounts().add(repository.findById(request.getIdTo()).get());
        return response;
    }

    @PutMapping("/putMoney")
    public AccountResponse putMoney(@RequestBody PutAndWithdrawMoneyRequest request) {
        AccountResponse response = new AccountResponse();
        repository.addSumToAmount(request.getId(), request.getSum());
        response.getAccounts().add(repository.findById(request.getId()).get());
        return response;
    }

    @PutMapping("/withDraw")
    public AccountResponse withDraw(@RequestBody PutAndWithdrawMoneyRequest request) {
        AccountResponse response = new AccountResponse();
        repository.subtractSumFromAmount(request.getId(), request.getSum());
        response.getAccounts().add(repository.findById(request.getId()).get());
        return response;
    }

    @GetMapping("/all")
    public List<Account> allAccounts() {
        return repository.findAll();
    }
}
