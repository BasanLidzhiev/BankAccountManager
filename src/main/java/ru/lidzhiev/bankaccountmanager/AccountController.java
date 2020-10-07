package ru.lidzhiev.bankaccountmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.lidzhiev.bankaccountmanager.Entity.Account;
import ru.lidzhiev.bankaccountmanager.repository.AccountRepository;

@RestController
public class AccountController {

    @Autowired
    AccountRepository repository;

    @GetMapping("/transferMoney")
    public void transferMoney(@RequestBody int id1, @RequestBody int id2, @RequestBody int sum) {
        Account account1 = repository.findById(id1).get();
        Account account2 = repository.findById(id2).get();
        account1.setAmount(account1.getAmount() - account2.getAmount());
        account2.setAmount(account1.getAmount() + account2.getAmount());

    }

    @GetMapping("/makeDeposit")
    public void makeDeposit() {

    }

    @GetMapping("/withDraw")
    public void withDraw() {

    }
}
