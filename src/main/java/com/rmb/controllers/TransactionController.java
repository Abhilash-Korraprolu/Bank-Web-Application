package com.rmb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rmb.entities.Account;
import com.rmb.entities.Transaction;
import com.rmb.services.AccountService;
import com.rmb.services.TransactionService;

@Controller
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@Autowired
	AccountService accountService;

	@GetMapping("account")
	public String displayAccountTransactions(@RequestParam String accountNumber, Model model) {

		Account account = accountService.findById(accountNumber);
		List<Transaction> transactions = transactionService.findAccountTransactions(accountNumber);

		model.addAttribute("account", account);
		model.addAttribute("transactions", transactions);

		return "account";
	}
}
