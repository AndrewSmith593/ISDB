package com.example.demo.sandwich;

import java.util.List;

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

	@GetMapping
	public Sandwich getSandwichByName(String name) {
		return sandwichRepository.findSandwichByName(name);
	}

	public Sandwich addSandwich(Sandwich sandwich) {
		Sandwich sandwichByName = sandwichRepository
				.findSandwichByName(sandwich.getName());
		// if the sandwich name is already in the db, throw exception
		if (sandwichByName != null) {
			throw new IllegalStateException("The sandwich name "
					+ sandwich.getName()
					+ " is already in the database. Please choose a different name.");
		}
		sandwichRepository.save(sandwich);
		return sandwich;
	}

	public void deleteSandwich(Integer sandwichId) {
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
	public void updateSandwich(Sandwich sandwich) {
		Sandwich foundSandwich = sandwichRepository.findById(sandwich.getId())
				.orElseThrow(() -> new IllegalStateException("Sandwich with id "
						+ sandwich.getId() + " does not exist."));

		String newName = sandwich.getName();
		String newIngredients = sandwich.getIngredients();

		// if the new name isn't null, is at least 1 character, and isn't the
		// same as the previous name, setName of the sandwich to the new name
		if (newName != null && newName.length() > 0) {
			foundSandwich.setName(newName);
		}

		// same logic for setting the new ingredients
		if (newIngredients != null && newIngredients.length() > 0) {
			foundSandwich.setIngredients(newIngredients);
		}
		sandwichRepository.save(foundSandwich);
	}
}
