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
					"Peanutbutter, Jelly", 1, true, 1);

			Sandwich hamAndCheese = new Sandwich("Ham and Cheese",
					"Ham, Cheddar, Mayo, Mustard", 1, true, 1);

			Sandwich club = new Sandwich("Club",
					"Turkey, Ham, Bacon, Lettuce, Tomato, Mayo", 1, true, 1);

			Sandwich italian = new Sandwich("Italian",
					"Salami, Ham, Mortadella, Capicola, Lettuce, Tomato, Onion, Oilandvinegar, Bananapeppers",
					1, true, 1);

			Sandwich chickenParm = new Sandwich("Chicken Parm",
					"Chicken, Mozzarella, Marinara", 1, true, 1);

			Sandwich veggieLover = new Sandwich("Veggie Lover",
					"Hummus, Avocado, Lettuce, Tomato, Cucumber, Onion, Mayo, Provolone",
					1, true, 1);

			Sandwich turkeyBacon = new Sandwich("Turkey Bacon",
					"Turkey, Bacon, Cheddar, Avocado, Tomato, Mayo", 1, true,
					1);

			Sandwich meatballSub = new Sandwich("Meatball",
					"Meatballs, Mozzarella, Marinara", 1, true, 1);

			Sandwich blt = new Sandwich("BLT", "Bacon, Lettuce, Tomato, Mayo",
					1, true, 1);

			repository.saveAll(List.of(pbj, hamAndCheese, club, italian,
					chickenParm, veggieLover, turkeyBacon, meatballSub, blt));
		};
	}
}
