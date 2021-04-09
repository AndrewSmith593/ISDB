package com.example.demo.sandwichtype;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SandwichTypeConfig {

	@Bean
	CommandLineRunner sandwichTypeCommandLineRunner(
			SandwichTypeRepository repository) {
		return args -> {

			SandwichType type1 = new SandwichType(1, "Favorites");

			SandwichType type2 = new SandwichType(2, "Deli Classics");

			SandwichType type3 = new SandwichType(3, "Italian Inspired");

			SandwichType type4 = new SandwichType(4, "Vegetarian");

			SandwichType type5 = new SandwichType(5, "Seafood");

			SandwichType type6 = new SandwichType(6, "Quick & Easy");

			SandwichType type7 = new SandwichType(7, "Breakfast");

			SandwichType type8 = new SandwichType(8, "Experimental");

			repository.saveAll(List.of(type1, type2, type3, type4, type5, type6,
					type7, type8));
		};
	}
}
