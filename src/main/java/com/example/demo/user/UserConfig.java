package com.example.demo.user;

import java.util.Collections;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.sandwich.Sandwich;

@Configuration
public class UserConfig {
	List<Sandwich> emptySandwichList = Collections.<Sandwich>emptyList();
	@Bean
	CommandLineRunner userCommandLineRunner(UserRepository repository) {
		return args -> {

			User user1 = new User("CoolUser1", "tony@email.com", "pass1",
					emptySandwichList);

			User user2 = new User("CoolUser2", "joey@email.com", "pass2",
					emptySandwichList);

			repository.saveAll(List.of(user1, user2));
		};
	}
}
