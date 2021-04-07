package com.example.demo.user;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.sandwich.Sandwich;
import com.example.demo.sandwich.SandwichRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final SandwichRepository sandwichRepository;

	@Autowired
	public UserService(UserRepository userRepository,
			SandwichRepository sandwichRepository) {
		super();
		this.userRepository = userRepository;
		this.sandwichRepository = sandwichRepository;
	}

	@GetMapping
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@PostMapping
	public Optional<User> addUser(User user) {
		Optional<User> userById = userRepository.findUserById(user.getId());
		// if the user is already in the db, throw exception
		if (userById.isPresent()) {
			throw new IllegalStateException(
					"That user is already in the database.");
		}
		userRepository.save(user);
		return userById;
	}

	public void deleteUser(Integer userId) {
		boolean exists = userRepository.existsById(userId);
		// if the user id isn't in db, throw exception
		if (!exists) {
			throw new IllegalStateException(
					"User with id " + userId + " does not exist.");
		}
		userRepository.deleteById(userId);
	}

	public List<Sandwich> getUserSandwiches(int id) {
		return sandwichRepository.findSandwichesByCreatorId(id);

	}

	// with this annotation, the entity (user) goes into a managed state
	// this allows you avoid using queries
	@Transactional
	@PutMapping
	public void updateUser(Integer userId, String username, String email,
			String password) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new IllegalStateException(
						"User with id " + userId + " does not exist."));

		// if the new username isn't null, is at between 6 and 30 characters,
		// and isn't the same as the previous username, setUsername to the new
		// username
		if (username != null && username.length() >= 6
				&& username.length() <= 30
				&& !Objects.equals(user.getUsername(), username)) {
			user.setUsername(username);
		}

		// similar logic for setting the new email
		if (email != null && email.length() > 0
				&& !Objects.equals(user.getEmail(), email)) {
			user.setEmail(email);
		}

		// same logic for setting the new password
		if (password != null && password.length() >= 6
				&& password.length() <= 30
				&& !Objects.equals(user.getPassword(), password)) {
			user.setPassword(password);
		}
	}
}
