package ru.lidzhiev.bankaccountmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.lidzhiev.bankaccountmanager.Entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
