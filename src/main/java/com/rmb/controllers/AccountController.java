package com.rmb.controllers;

import javax.servlet.http.HttpSession;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rmb.entities.AccountCreationRequest;
import com.rmb.services.AccountService;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("createAccount")
	public String newAccountForm(@RequestParam String pno, Model model, HttpSession session) {

		// model.addAttribute("account", new Account)
		session.setAttribute("pno", pno);

		System.out.println("Pno is: " + pno);
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
