package com.rmb.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rmb.Constants;
import com.rmb.entities.Account;
import com.rmb.entities.AccountCreationRequest;
import com.rmb.entities.User;
import com.rmb.services.AccountService;
import com.rmb.services.UserService;

@Controller
public class AccountController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AccountService accountService;


	@GetMapping("createAccount")
//	@PreAuthorize("hasPermission('CREATE_ACCOUNT_FOR_ANY_USER')")
	public String newAccountForm(@RequestParam String pno, Model model, HttpSession session) {
	//	Constants.Permissions.CREATE_ACCOUNT_FOR_ANY_USER
		session.setAttribute("pno", pno);
		
		return "accountCreationForm";
	}

	@PostMapping("createAccount")
	public String createNewAccount(@Valid AccountCreationRequest accountCreationRequest, BindingResult bindingResult,
			HttpSession session) {

		if (bindingResult.hasErrors())
			return "accountCreationForm";

		String pno = (String) session.getAttribute("pno");
		accountService.createAccount(pno, accountCreationRequest);

		return "redirect:/users";
	}
	
//	@GetMapping("/transfer")
//	public String goToTransferPage(Principal principal, Model model) {
//
//		User user = userService.findByPno(principal.getName());
//		List<Account> accounts = accountService.findUserAccounts(user);
//
//		model.addAttribute("accounts", accounts);
//
//		return "transfer";
//	}
	
	
	
//		public void accountClosing() {
//			
//			/*
//			 * 1. Check balance = 0;
//			 * 2. Closing time stamp
//			 * 3. check actor permissions
//			 * 4. Decouple
//			 */
//		}

//	@GetMapping("account")
//	public String displaySelectedAccount(@RequestParam String accountNumber, Model model) {
//		
//		Account account = accountService.findById(accountNumber);
//		model.addAttribute("account", account);
//			
//		return "account";
//	}

}
