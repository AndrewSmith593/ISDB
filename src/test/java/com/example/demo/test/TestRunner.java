package com.example.demo.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(JunitTestSuite.class);

		System.out.println("There were " + result.getFailureCount()
				+ " failures out of 4 tests:\n");

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString() + '\n');
		}

		System.out.println("Test successful: " + result.wasSuccessful());
	}

}
