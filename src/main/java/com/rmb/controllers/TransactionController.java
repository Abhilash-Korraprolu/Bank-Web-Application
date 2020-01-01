package com.rmb.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rmb.entities.Account;
import com.rmb.entities.Transaction;
import com.rmb.entities.User;
import com.rmb.services.AccountService;
import com.rmb.services.TransactionService;
import com.rmb.services.UserService;

@Controller
public class TransactionController {

	@Autowired
	private UserService userService;

	@Autowired
	TransactionService transactionService;

	@Autowired
	AccountService accountService;

	@PostMapping("account")
	public String displayAccountTransactions(@RequestParam String accountNumber, Model model) {

		Account account = accountService.findById(accountNumber);
		List<Transaction> transactions = transactionService.findAccountTransactions(accountNumber);

		model.addAttribute("account", account);
		model.addAttribute("transactions", transactions);

		return "account";
	}

	@GetMapping("transfer")
	public String showTransferPage(Principal principal, Model model) {

		User user = userService.findByPno(principal.getName());
		List<Account> accounts = accountService.findUserAccounts(user);
		model.addAttribute("userName", user.getFirstName());
		model.addAttribute("accounts", accounts);

		return "payTransfer";
	}

	@PostMapping("performTransfer")
	public String makeNewTransfer(@RequestParam String sendersAccountNumber,
			@RequestParam String receiversAccountNumber, @RequestParam double amount) {

		transactionService.transfer(sendersAccountNumber, receiversAccountNumber, amount);
		return "transferStatus";
	}
}
