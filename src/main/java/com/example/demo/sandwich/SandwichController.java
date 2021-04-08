package com.example.demo.sandwich;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/sandwich")
public class SandwichController {

	@Autowired
	private final SandwichService sandwichService;

	@Autowired
	public SandwichController(SandwichService sandwichService) {
		super();
		this.sandwichService = sandwichService;
	}

	@GetMapping
	public List<Sandwich> getSandwiches() {
		return sandwichService.getSandwiches();
	}

	@PostMapping
	public void addSandwich(@RequestBody Sandwich sandwich) {
		sandwichService.addSandwich(sandwich);
	}

	@PutMapping
	public void updateSandwich(@RequestParam("id") Integer sandwichId,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String ingredients) {
		System.out.println("sandwichId is: " + sandwichId);
		System.out.println("new name is: " + name);
		System.out.println("new ingredients are: " + ingredients);
		sandwichService.updateSandwich(sandwichId, name, ingredients);
	}
}
