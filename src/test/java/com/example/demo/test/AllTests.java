package com.example.demo.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({SandwichTests.class, UserTests.class})
public class AllTests {

}
