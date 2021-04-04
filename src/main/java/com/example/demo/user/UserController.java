package com.example.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/user")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	// @PostMapping
	// public void addUser(@RequestBody User user) {
	// userService.addUser(user);
	// }

	@DeleteMapping(path = "{userId}")
	public void deleteUser(@PathVariable("userId") Integer userId) {
		userService.deleteUser(userId);
	}

	@PutMapping(path = "{userId}")
	public void updateUser(@PathVariable("userId") Integer userId,
			@RequestParam(required = false) String username,
			@RequestParam(required = false) String email,
			@RequestParam(required = false) String password) {
		userService.updateUser(userId, username, email, password);
	}
}
