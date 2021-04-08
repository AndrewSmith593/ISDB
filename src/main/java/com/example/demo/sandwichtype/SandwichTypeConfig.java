// package com.example.demo.sandwichtype;
//
// import java.util.List;
//
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
//
// @Configuration
// public class SandwichTypeConfig {
//
// @Bean
// CommandLineRunner sandwichTypeCommandLineRunner(
// SandwichTypeRepository repository) {
// return args -> {
//
// SandwichType type1 = new SandwichType(1, "Favorite");
//
// SandwichType type2 = new SandwichType(2, "Meaty");
//
// SandwichType type3 = new SandwichType(3, "Vegetarian");
//
// repository.saveAll(List.of(type1, type2, type3));
// };
// }
// }
