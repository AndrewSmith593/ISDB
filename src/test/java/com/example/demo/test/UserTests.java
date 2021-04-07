package com.example.demo.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;

import java.util.Collections;
import java.util.List;

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
		System.out.println("hello from tests");
		userRepository = Mockito.mock(UserRepository.class);
		userService = new UserService(userRepository, sandwichRepository);
	}

	@Test
	public void testFindByUsername() {
		System.out.println("hello from tests");
		Mockito.when(userRepository.findByUsername(anyString()))
				.thenReturn(new User("TestUser3", "bob@email.com", "pass3",
						emptySandwichList));
		User actual = userService.getUserByUsername("testUser1");
		String expected = "testPass1";
		assertEquals(expected, actual.getPassword());
	}

	@Test
	public void testSave() {

		System.out.println("hello from tests");

		Mockito.when(userRepository.save(anyObject())).thenReturn(new User(
				"TestUser3", "bob@email.com", "pass3", emptySandwichList));
		User actual = userService.addUser(new User());
		User expected = new User("TestUser3", "bob@email.com", "pass3",
				emptySandwichList);
		assertEquals(expected, actual);
	}
}