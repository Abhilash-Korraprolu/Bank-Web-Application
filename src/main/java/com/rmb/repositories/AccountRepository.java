package com.rmb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmb.entities.Account;
import com.rmb.entities.User;

public interface AccountRepository extends JpaRepository<Account, String> {

	List<Account> findByUser(User user);
}
