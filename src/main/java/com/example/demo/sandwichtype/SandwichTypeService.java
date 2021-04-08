// package com.example.demo.sandwichtype;
//
// import java.util.List;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
//
// @Service
// public class SandwichTypeService {
//
// private final SandwichTypeRepository sandwichTypeRepository;
//
// @Autowired
// public SandwichTypeService(SandwichTypeRepository sandwichTypeRepository) {
// super();
// this.sandwichTypeRepository = sandwichTypeRepository;
// }
//
// @GetMapping
// public List<SandwichType> getAllSandwichTypes() {
// return sandwichTypeRepository.findAll();
// }
//
// @PostMapping
// public SandwichType addSandwichType(SandwichType sandwichType) {
// SandwichType sandwichTypeById = sandwichTypeRepository
// .findSandwichTypeById(sandwichType.getId());
// // if the sandwich type is already in the db, throw exception
// if (sandwichTypeById != null) {
// throw new IllegalStateException(
// "That type is already in the database.");
// }
// sandwichTypeRepository.save(sandwichType);
// return sandwichType;
// }
//
// public void deleteSandwichType(Integer sandwichTypeId) {
// boolean exists = sandwichTypeRepository.existsById(sandwichTypeId);
// // if the user id isn't in db, throw exception
// if (!exists) {
// throw new IllegalStateException(
// "User with id " + sandwichTypeId + " does not exist.");
// }
// sandwichTypeRepository.deleteById(sandwichTypeId);
// }
//
// }
