package com.example.demo.sandwich;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SandwichRepository extends JpaRepository<Sandwich, Integer> {

//	this translates to: SELECT * FROM sandwich WHERE name = ?
	Optional<Sandwich> findSandwichByName(String name);

}
