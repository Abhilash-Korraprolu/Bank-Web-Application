package com.rmb.controllers;

import java.security.Principal;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.rmb.entities.Account;
import com.rmb.entities.Permission;
import com.rmb.entities.User;
import com.rmb.services.AccountService;
import com.rmb.services.PermissionService;
import com.rmb.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private PermissionService permissionService;

	@GetMapping("/")
	public String displayUser(Principal principal, Model model) {

		User user = userService.findByPno(principal.getName());
		List<Account> accounts = accountService.findUserAccounts(user);

		model.addAttribute("user", user);
		model.addAttribute("accounts", accounts);

		return "user";
	}

	@GetMapping("users")
	public String listAllUsers(Model model, @RequestParam(defaultValue = "") String pno,
			@RequestParam(defaultValue = "") String firstName, @RequestParam(defaultValue = "") String lastName,
			@RequestParam(defaultValue = "") String city, @RequestParam(defaultValue = "") String email,
			@RequestParam(defaultValue = "") String phoneNumber) {

		model.addAttribute("users", userService.searchUser(pno, firstName, lastName, city, email, phoneNumber));
		return "searchUsers";
	}

	@GetMapping("register")
	public String getRegisterForm(Model model) {
		
		List<Permission> permissions = userService.getUserAdminPermissions();	
		model.addAttribute("permissions", permissions);

		return "registerUser";
	}

	@PostMapping("register")
	public String registerUser(@Valid User user, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {

			List<ObjectError> l = bindingResult.getAllErrors();
//			for (ObjectError e : l)
//				System.out.println(e.toString());

			return "registerUser";
		}
//		Note to self: Already checking using @Valid right? Then why this again?

		if (userService.checkIfAlreadyRegisteredPno(user.getPno())) {

			model.addAttribute("pnoExists", true);
			return "registerUser";
		}

		if (userService.checkIfAlreadyRegisteredEmail(user.getEmail())) {
			model.addAttribute("emailExists", true);
			return "registerUser";
		}

		userService.createUser(user);
//		userService.createAdmin(user);
		return "registrationSuccessful";
	}

}
