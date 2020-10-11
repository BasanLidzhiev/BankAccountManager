package ru.lidzhiev.bankaccountmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.lidzhiev.bankaccountmanager.entity.Account;

import javax.transaction.Transactional;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Account SET amountOfMoney = amountOfMoney+?2 WHERE id = ?1 ")
    void addSumToAmount(int id, int sum);

    @Transactional
    @Modifying
    @Query("UPDATE Account SET amountOfMoney = amountOfMoney-?2 WHERE id = ?1 ")
    void subtractSumFromAmount(int id, int sum);

}
