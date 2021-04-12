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
			Sandwich pbj = new Sandwich(1, "Peanut Butter and Jelly",
					"White, Peanutbutter, Jelly", 1, true, 1);

			Sandwich hamAndCheese = new Sandwich("Ham and Cheese",
					"White, Ham, Cheddar, Mayo, Mustard", 1, true, 1);

			Sandwich club = new Sandwich("Club",
					"White, Turkey, Ham, Bacon, Lettuce, Tomato, Mayo", 1, true,
					1);

			Sandwich italian = new Sandwich("Italian",
					"Subroll, Salami, Ham, Mortadella, Capicola, Lettuce, Tomato, Onion, Oilandvinegar, Bananapeppers",
					1, true, 1);

			Sandwich chickenParm = new Sandwich("Chicken Parm",
					"Subroll, Chicken, Mozzarella, Marinara", 1, true, 1);

			Sandwich veggieLover = new Sandwich("Veggie Lover",
					"Wheat, Hummus, Avocado, Lettuce, Tomato, Cucumber, Onion, Mayo, Provolone",
					1, true, 1);

			Sandwich turkeyBacon = new Sandwich("Turkey Bacon",
					"Wheat, Turkey, Bacon, Cheddar, Avocado, Tomato, Mayo", 1,
					true, 1);

			Sandwich meatballSub = new Sandwich("Meatball",
					"Subroll, Meatballs, Mozzarella, Marinara", 1, true, 1);

			Sandwich blt = new Sandwich("BLT",
					"Wheat, Bacon, Lettuce, Tomato, Mayo", 1, true, 1);

			repository.saveAll(List.of(pbj, hamAndCheese, club, italian,
					chickenParm, veggieLover, turkeyBacon, meatballSub, blt));
		};
	}
}
