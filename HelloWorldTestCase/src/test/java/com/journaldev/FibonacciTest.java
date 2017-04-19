package com.journaldev;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.hamcrest.generator.qdox.model.Type;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FibonacciTest {
       @Parameters
       public static Collection<Object[]> data() {
               return Arrays.asList(new Object[][] 
                               { { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 },
                                               { 6, 8 } } );
       }

       private int fInput;

       private int fExpected;

       public FibonacciTest(int input, int expected) {
               fInput= input;
               fExpected= expected;
       }

       @Test
       public void test() {
              // assertAnswerKey(new Object[][] {
//                               Fibonacci,
//                               { { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 },
//                                               { 6, 8 } } });
               assertEquals(fExpected, new Fibonacci().compute(fInput));
       }
}
