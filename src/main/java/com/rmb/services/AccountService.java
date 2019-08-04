package com.rmb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmb.Constants;
import com.rmb.customExceptions.InvalidAccountException;
import com.rmb.entities.Account;
import com.rmb.entities.AccountCreationRequest;
import com.rmb.entities.CurrentAccount;
import com.rmb.entities.SavingsAccount;
import com.rmb.entities.User;
import com.rmb.repositories.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private UserService userService;

	@Autowired
	private AccountRepository accountRepository;

	public void addAccount(User user, Account account) {

		account.setUser(user);
		accountRepository.save(account);
	}

	public List<Account> getUsersAccounts(User user) {

		return accountRepository.findByUser(user);
	}

	public void createAccount(String pno, AccountCreationRequest rq) {

		User user = userService.findByPnoTemp(pno);
		Account account = null;

		if (rq.getAccountType().equals(Constants.AccountType.current))
			account = new CurrentAccount(user, rq.getInitialDeposit(), rq.getCurrencyType());

		else if (rq.getAccountType().equals(Constants.AccountType.savings))
			account = new SavingsAccount(user, rq.getInitialDeposit(), rq.getCurrencyType());

		accountRepository.save(account);
	}

	public List<Account> findUserAccounts(User user) {

		return accountRepository.findByUser(user);
	}

	public Account findById(String accountNumber) {

		return accountRepository.findById(accountNumber).orElseThrow(() -> new InvalidAccountException(accountNumber));
	}

	// Read account

	// update account

	// delete account
}
