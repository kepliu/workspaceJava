package com.journaldev;
 
import java.io.File;
import java.io.UnsupportedEncodingException;
 
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.journaldev.categories.Optional;

import static org.junit.Assert.*;
@Category(Optional.class) 
public class HelloWorldTestCase {
 
    @BeforeClass
    public static void beforeExecutingHelloWorldTestCases(){
        System.out.println("Before Executing HelloWorldTestCases :: ");
    }
 
    @AfterClass
    public static void afterExecutingHelloWorldTestCases(){
        System.out.println("After Executing HelloWorldTestCases :: ");
    }
 
    @Before
    public void beforeExecutingTestCase(){
        System.out.println("Before Executing Test Case :: ");
    }
 
    @After
    public void afterExecutingTestCase(){
        System.out.println("After Executing Test Case :: ");
    }
 
    @Test
    public void testHelloWorldOne(){
        // Print a message before assertion
        System.out.println("Before Getting Test #1 Started ::");
 
        // If assertion goes wrong, the execution of Test would fail
        assertEquals("Would Say Hello","Hello","Hello");
 
        // Print a message after execution of Test; if assertion goes well, this message would be shown
        System.out.println("After Test #1 Execution ::");
    }
 
    @Test
    public void testHelloWorldTwo(){
        // Print a message before assertion
        System.out.println("Before Getting Test #2 Started ::");
 
        // If assertion goes wrong, the execution of Test would fail
        assertEquals("Would Say Hello","Hello","Hello");
 
        // Print a message after execution of Test; if assertion goes well, this message would be shown
        System.out.println("After Test #2 Execution ::");
    }   
 
    @Test(timeout=1)
    public void testWaitForATime(){
        // Print statement
        System.out.println("@Test Will Be Waiting For 1 Milliseconds :: Supposed Task Should Be Done Before Timeout");
 
        // Some adhoc processing
        for(int i = 0 ; i < 1000 ; i++){
            Math.random();
        }
        // Print statement
        System.out.println("Task Done Before Timeout :: This Test Has Finished Sucessfully ::");
    }
 
    @Test(expected=NullPointerException.class)
    public void testNullPointerExceptionShouldBeRaised() throws UnsupportedEncodingException{
        // Define variable
        String variable = null;
        // Get random number
        double value = Math.random() * 100;
 
        // Print out value
        System.out.println("Value :: "+(int)value);
 
        if((int)value % 2 == 0){
            // Specify variable value
            variable = "Even Number";
        }
        // Print out variable content with UTF-8 encoding
        System.out.println("This number is :: "+new String(variable.getBytes(),"UTF-8"));
    }
 
}