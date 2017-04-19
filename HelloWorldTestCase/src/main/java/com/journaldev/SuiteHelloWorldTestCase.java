package com.journaldev;
 
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
 
@RunWith(Suite.class)
@SuiteClasses({ParametrizedHelloWorldTestCase.class, HelloWorldTestCase.class})
public class SuiteHelloWorldTestCase {
 
}