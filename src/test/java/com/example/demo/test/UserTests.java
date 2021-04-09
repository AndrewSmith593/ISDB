package com.example.demo.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;

import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.example.demo.sandwich.Sandwich;
import com.example.demo.sandwich.SandwichRepository;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import com.example.demo.user.UserService;

public class UserTests {
	private static UserService userService;
	private static UserRepository userRepository;
	private static SandwichRepository sandwichRepository;
	List<Sandwich> emptySandwichList = Collections.<Sandwich>emptyList();

	@BeforeClass
	public static void setup() {
		userRepository = Mockito.mock(UserRepository.class);
		userService = new UserService(userRepository, sandwichRepository);
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Preparing test");
	}

	@After
	public void postTest() {
		// Integer userId = userService.getUserByUsername("TestUser4").getId();
		// userService.deleteUser(userId);
		System.out.println("Finished test\n");
	}

	@Test
	public void testFindByUsername() {
		System.out.println("Running testFindByUsername()...");
		Mockito.when(userRepository.findByUsername(anyString()))
				.thenReturn(new User("TestUser3", "bob@email.com", "testPass3",
						emptySandwichList));
		User actual = userService.getUserByUsername("TestUser3");
		String expected = "testPass3";
		assertEquals(expected, actual.getPassword());
	}

	@Test
	public void testSaveUser() {
		System.out.println("Running testSaveUser()...");
		Mockito.when(userRepository.save(anyObject())).thenReturn(new User(
				"TestUser4", "bob@email.com", "testPass4", emptySandwichList));
		User actual = userService.addUser(new User());
		User expected = new User("TestUser4", "bob@email.com", "testPass4",
				emptySandwichList);
		assertEquals(expected, actual);
	}
}