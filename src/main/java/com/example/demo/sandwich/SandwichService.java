package com.example.demo.sandwich;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class SandwichService {

	private final SandwichRepository sandwichRepository;

	@Autowired
	public SandwichService(SandwichRepository sandwichRepository) {
		super();
		this.sandwichRepository = sandwichRepository;
	}

	@GetMapping
	public List<Sandwich> getSandwiches() {
		return sandwichRepository.findAll();
	}

	public void addSandwich(Sandwich sandwich) {
		Optional<Sandwich> sandwichByName = sandwichRepository
				.findSandwichByName(sandwich.getName());
		// if the sandwich name is already in the db, throw exception
		if (sandwichByName.isPresent()) {
			throw new IllegalStateException(
					"That sandwich name is already in the database. Please choose a different name.");
		}
		sandwichRepository.save(sandwich);
	}

	public void deleteSandwich(Integer sandwichId) {
		System.out.println("deleteSandwich in sandservice fired off");

		boolean exists = sandwichRepository.existsById(sandwichId);
		// if the sandwich id isn't in db, throw exception
		if (!exists) {
			throw new IllegalStateException(
					"Sandwich with id " + sandwichId + " does not exist.");
		}
		sandwichRepository.deleteById(sandwichId);
	}

	// with this annotation, the entity (sandwich) goes into a managed state
	// this allows you avoid using queries
	@Transactional
	public void updateSandwich(Integer sandwichId, String name,
			String ingredients) {
		Sandwich sandwich = sandwichRepository.findById(sandwichId)
				.orElseThrow(() -> new IllegalStateException(
						"Sandwich with id " + sandwichId + " does not exist."));

		// if the new name isn't null, is at least 1 character, and isn't the
		// same as the previous name, setName of the sandwich to the new name
		if (name != null && name.length() > 0
				&& !Objects.equals(sandwich.getName(), name)) {
			sandwich.setName(name);
		}

		// same logic for setting the new ingredients
		if (ingredients != null && ingredients.length() > 0
				&& !Objects.equals(sandwich.getIngredients(), ingredients)) {
			sandwich.setIngredients(ingredients);
		}
	}
}
