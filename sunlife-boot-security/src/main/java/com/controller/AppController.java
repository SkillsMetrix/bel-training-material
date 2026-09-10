package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller

public class AppController {
	@GetMapping("/welcome")
	public String sayWelcome() {
		return "welcome";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/student")
	public String student() {
		return "student";
	}
	@GetMapping("/access-denied")
	public String ad() {
		return "access-denied";
	}
	@GetMapping("/trainer")
	public String trainer() {
		return "trainer";
	}
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	@GetMapping("/home")
	public String home() {
		return "home";
	}
}
