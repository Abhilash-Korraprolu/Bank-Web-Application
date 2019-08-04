package com.rmb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/login")
	public String loginPage() {
		return "index";
	}

	@GetMapping("/logout-success")
	public String logoutPage() {
		return "logout";
	}
}
