package com.example.demo.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

	// this translates to: SELECT * FROM user WHERE id = ?
	Optional<User> findUserById(Integer id);

	// this translates to: SELECT * FROM user WHERE username = ?
	User findByUsername(String username);

}
