package com.example.demo.sandwich;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SandwichConfig {

	@Bean
	CommandLineRunner commandLineRunner(SandwichRepository repository) {
		return args -> {
			Sandwich pbj = new Sandwich(1, "Peanut Butter and Jelly", "White Bread, Peanut Butter, Jelly", 1, true, 1);

			Sandwich hamAndCheese = new Sandwich("Ham and Cheese", "White Bread, Ham, Cheddar", 1, true, 1);

			repository.saveAll(List.of(pbj, hamAndCheese));
		};
	}
}
