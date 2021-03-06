package com.example.demo.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.example.demo.sandwich.Sandwich;
import com.example.demo.sandwich.SandwichRepository;
import com.example.demo.sandwich.SandwichService;

public class SandwichTests {

	private static SandwichService sandwichService;
	private static SandwichRepository sandwichRepository;

	@BeforeClass
	public static void setup() {
		sandwichRepository = Mockito.mock(SandwichRepository.class);
		sandwichService = new SandwichService(sandwichRepository);
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Preparing test");
	}

	@After
	public void postTest() {
		// sandwichService.deleteSandwich(1);
		System.out.println("Finished test\n");
	}

	@Test
	public void testFindSandwichByName() {
		System.out.println("Running testFindSandwichByName()...");
		Mockito.when(sandwichRepository.findSandwichByName(anyString()))
				.thenReturn(new Sandwich(1, "TBC", "Turkey, Bacon, Cheddar", 1,
						true, 1));
		Sandwich actual = sandwichService.getSandwichByName("TBC");
		String expected = "TBC";
		assertEquals(expected, actual.getName());
	}

	@Test
	public void testSaveSandwich() {
		System.out.println("Running testSaveSandwich()...");
		Mockito.when(sandwichRepository.save(anyObject()))
				.thenReturn(new Sandwich(1, "TestSandwich",
						"Chicken, Mozzarella, Marinara", 1, true, 1));

		// Sandwich testSandwich = new Sandwich(6, "CParm5",
		// "Chicken, Mozzarella, Marinara", 1, true, 1);

		// sandwichService.addSandwich(testSandwich);

		Sandwich actual = sandwichService.addSandwich(new Sandwich());

		Sandwich expected = new Sandwich(1, "TestSandwich",
				"Chicken, Mozzarella, Marinara", 1, true, 1);

		assertEquals(expected, actual);
	}
}
