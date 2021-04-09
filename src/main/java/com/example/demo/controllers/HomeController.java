package com.example.demo.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.sandwich.SandwichService;
import com.example.demo.user.User;
import com.example.demo.user.UserService;

@Controller
public class HomeController {

	public Integer currentUserId;

	@Autowired
	private UserService userService;

	@Autowired
	private SandwichService sandwichService;

	@GetMapping("/")
	public String getHomePage() {
		return "index";
	}

	@GetMapping("/logout")
	public String getLoggedOutPage(HttpSession session) {
		session.invalidate();
		return "loggedout";
	}

	@GetMapping("/loginfail")
	public String getLoginFailPage() {
		return "loginfail";
	}

	@GetMapping("/create")
	public String getCreatePage() {
		return "create";
	}

	@GetMapping("/api/v1/sandwich/edit/{id}/{name}/{ingredients}")
	public String getEditPage() {
		return "edit";
	}

	@GetMapping("/menu")
	public String getMenuPage(HttpSession session) {
		session.setAttribute("allSandwiches", sandwichService.getSandwiches());
		return "menu";
	}

	@GetMapping("/register")
	public String getRegisterPage() {
		return "register";
	}

	@GetMapping("/mysandwiches")
	public String getMySandwichesPage(HttpSession session) {

		session.setAttribute("currentUserSandwiches",
				userService.getUserSandwiches(
						(int) session.getAttribute("currentUserId")));
		return "mysandwiches";
	}

	@PostMapping("/api/v1/sandwich/delete/{id}")
	public String deleteSandwich(@PathVariable("id") Integer sandwichId,
			HttpSession session) {

		sandwichService.deleteSandwich(sandwichId);

		session.setAttribute("currentUserSandwiches",
				userService.getUserSandwiches(
						(int) session.getAttribute("currentUserId")));

		return "mysandwiches";
	}

	@PostMapping("/api/v1/sandwich/edit/{id}/{name}/{ingredients}")
	public String getEditPage(@PathVariable("id") Integer sandwichId,
			@PathVariable("name") String name,
			@PathVariable("ingredients") String ingredients,
			HttpSession session) {
		System.out.println("hello from getEditPage in home controller");

		// Integer sId = Integer.parseInt(sandwichId);

		session.setAttribute("editSandwichId", sandwichId);
		session.setAttribute("editSandwichName", name);
		session.setAttribute("editSandwichIngredients", ingredients);

		return "edit";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String processLoginRequest(HttpServletRequest request,
			@RequestParam("username") String username,
			@RequestParam("password") String password, Model model,
			HttpSession session) {

		User user = userService.getUserByUsername(username);

		currentUserId = user.getId();
		System.out.println("user.getId is: " + currentUserId);

		if (user != null && password.equals(user.getPassword())) {
			session.setAttribute("allSandwiches",
					sandwichService.getSandwiches());
			session.setAttribute("currentUser", user);
			session.setAttribute("currentUsername", user.getUsername());
			session.setAttribute("currentUserId", user.getId());
			System.out.println("User logged in successfully.");
			return "menu";
		} else {
			System.out.println("Login failed");
			model.addAttribute("loginFailedMessage", "Login failed.");
			return "loginfail";
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addUser(User user) {
		userService.addUser(user);
		return "menu";
	}

}
