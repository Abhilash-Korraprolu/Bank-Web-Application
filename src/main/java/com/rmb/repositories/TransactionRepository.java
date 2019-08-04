package com.rmb.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmb.entities.Account;
import com.rmb.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	List<Transaction> findByAccount(Account account);

	List<Transaction> findByAccount(Optional<Account> findById);
}
