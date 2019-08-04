package com.rmb.services;

import java.util.List;

import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmb.Constants;
import com.rmb.customExceptions.InvalidAccountException;
import com.rmb.entities.Account;
import com.rmb.entities.Transaction;
import com.rmb.repositories.AccountRepository;
import com.rmb.repositories.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	AccountRepository accountRepository;

	public void transfer(String senderAccountNumber, String receiverAccountNumber, double amount) {

		Account sender = accountRepository.findById(senderAccountNumber)
				.orElseThrow(() -> new InvalidAccountException(senderAccountNumber));
		checkAccountStatus(sender);
		Account receiver = accountRepository.findById(receiverAccountNumber)
				.orElseThrow(() -> new InvalidAccountException(receiverAccountNumber));
		checkAccountStatus(receiver);

		double senderBalance = sender.getBalance();
		senderBalance -= amount;
		sender.setBalance(senderBalance);
		Transaction senderTransaction = new Transaction(sender, receiverAccountNumber, "-" + amount, senderBalance);
		transactionRepository.save(senderTransaction);

		double receiverBalance = receiver.getBalance();
		receiverBalance += amount;
		receiver.setBalance(receiverBalance);
		Transaction receiverTransaction = new Transaction(receiver, senderAccountNumber, "+" + amount, receiverBalance);
		transactionRepository.save(receiverTransaction);

		System.out.println("Transfer completed");
	}

	public void checkAccountStatus(Account account) {

		if (account.getStatus().equals(Constants.Status.CLOSED))
			throw new TransactionException("The account: " + account.getAccountNumber() + " has been closed.");

	}

	public List<Transaction> findAccountTransactions(String accountNumber) {

		List<Transaction> transactions = transactionRepository.findByAccount(accountRepository.findById(accountNumber));
		transactions.sort((t1, t2) -> Double.compare(t2.getId(), t1.getId()));

		return transactions;
	}
}
