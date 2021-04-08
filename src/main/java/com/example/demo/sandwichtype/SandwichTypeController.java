// package com.example.demo.sandwichtype;
//
// import java.util.List;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
//
// @RestController
// @RequestMapping
// public class SandwichTypeController {
//
// @Autowired
// private final SandwichTypeService sandwichTypeService;
//
// @Autowired
// public SandwichTypeController(SandwichTypeService sandwichTypeService) {
// super();
// this.sandwichTypeService = sandwichTypeService;
// }
//
// @GetMapping
// public List<SandwichType> getSandwichTypes() {
// return sandwichTypeService.getAllSandwichTypes();
// }
//
// @PostMapping
// public void addSandwichType(@RequestBody SandwichType sandwichType) {
// sandwichTypeService.addSandwichType(sandwichType);
// }
//
// // @PutMapping
// // public void updateSandwich(@PathVariable("id") Integer sandwichId,
// // @RequestParam(required = false) String name,
// // @RequestParam(required = false) String ingredients) {
// // System.out.println("hi from updatesandwich in controller");
// // System.out.println("sandwichId is: " + sandwichId);
// // System.out.println("new name is: " + name);
// // System.out.println("new ingredients are: " + ingredients);
// // sandwichService.updateSandwich(sandwichId, name, ingredients);
// // }
// }
