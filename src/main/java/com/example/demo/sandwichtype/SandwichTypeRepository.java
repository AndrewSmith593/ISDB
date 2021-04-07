package com.example.demo.sandwichtype;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SandwichTypeRepository
		extends
			JpaRepository<SandwichType, Integer> {

	SandwichType findSandwichTypeById(Integer id);

	SandwichType findSandwichTypeByTypeName(String typeName);
}
