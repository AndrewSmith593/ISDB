package com.example.demo.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.user.User;
import com.example.demo.user.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String getHomePage() {
		return "index";
	}

	@GetMapping("/create")
	public String getCreatePage() {
		return "create";
	}

	@GetMapping("/menu")
	public String getMenuPage() {
		return "menu";
	}

	@GetMapping("/register")
	public String getRegisterPage() {
		return "register";
	}

	@GetMapping("/mysandwiches")
	public String getMySandwichesPage() {
		return "mysandwiches";
	}

	// @PostMapping("/")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String processLoginRequest(HttpServletRequest request,
			@RequestParam("username") String username,
			@RequestParam("password") String password, Model model,
			HttpSession session) {

		User user = userService.getUserByUsername(username);

		System.out.println(user.getuSandwiches().toString());

		session.setAttribute("currentUserId", user.getId());

		session.setAttribute("currentUserSandwiches", user.getuSandwiches());

		if (user != null && password.equals(user.getPassword())) {
			session.setAttribute("currentUser", user);
			System.out.println("User logged in successfully.");
			return "menu";
		}
		System.out.println("Login failed");
		model.addAttribute("loginFailedMessage", "Login failed.");
		return "menu";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addUser(User user) {
		userService.addUser(user);
		return "menu";
	}

}
