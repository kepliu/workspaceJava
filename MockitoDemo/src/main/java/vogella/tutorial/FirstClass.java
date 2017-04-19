package vogella.tutorial;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.mockito.Matchers;

import static org.junit.Assert.*;
public class FirstClass {
	@Test
	public void test1() throws IOException  {
	  //  create mock
	  MyClass test = mock(MyClass.class);
	  
	  // define return value for method getUniqueId()
	  when(test.getUniqueId()).thenReturn(43);
	  
	  // use mock in test.... 
	  assertEquals(test.getUniqueId(), 43);
	}
	// Demonstrates the return of multiple values
	@Test
	public void testMoreThanOneReturnValue()  {
	  Iterator i= mock(Iterator.class);
	  when(i.next()).thenReturn("Mockito").thenReturn("rocks");
	  String result=i.next()+" "+i.next();
	  //assert
	  assertEquals("Mockito rocks", result);
	}

	// this test demonstrates how to return values based on the input
	@Test
	public void testReturnValueDependentOnMethodParameter()  {
		
	  Comparable c  = mock(Comparable.class);
	  when(c.compareTo("Mockito")).thenReturn(1);
	  when(c.compareTo("Eclipse")).thenReturn(2);
	  //assert
	  assertEquals(1,c.compareTo("Mockito"));
	}

	// this test demonstrates how to return values independent of the input value

	@Test
	public void testReturnValueInDependentOnMethodParameter()  {
	  Comparable c= mock(Comparable.class);
	  when(c.compareTo(anyInt())).thenReturn(-1);
	  //assert
	  assertEquals(-1 ,c.compareTo(9));
	}
	// return a value based on the type of the provide parameter

	@Test
	public void testReturnValueInDependentOnMethodParameter1()  {
	  Comparable c= mock(Comparable.class);
	  when(c.compareTo(isA(Todo.class))).thenReturn(0);
	  //assert
	  Todo todo = new Todo(5);
	  assertEquals(0 ,c.compareTo(new Todo(1)));
	}
	// this test demonstrates how use doThrow

	@Test(expected=IOException.class)
	public void testForIOException() throws IOException{
	  // create an configure mock
	  MyClass myclass = mock(MyClass.class);
//	  try {
		doThrow(new IOException()).when(myclass).getUniqueId();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	  
	  // use mock
		myclass.getUniqueId();

	} 
	@Test
	public void testVerify() throws IOException  {
	  // create and configure mock
	  MyClass test = mock(MyClass.class);
	  when(test.getUniqueId()).thenReturn(43);
	  
	  
	  // call method testing on the mock with parameter 12
	  test.testing(12);
	  test.getUniqueId();
	  test.getUniqueId();
	  
	  
	  // now check if method testing was called with the parameter 12 
	  verify(test).testing(Matchers.eq(12));
	  
	  // was the method called twice?
	  verify(test, times(2)).getUniqueId();
	  
	  // other alternatives for verifiying the number of method calls for a method
//	  verify(mock, never()).someMethod("never called");
//	  verify(mock, atLeastOnce()).someMethod("called at least once");
//	  verify(mock, atLeast(2)).someMethod("called at least twice");
//	  verify(mock, times(5)).someMethod("called five times");
//	  verify(mock, atMost(3)).someMethod("called at most 3 times");
	} 
	@Test
	public void testVoidReturn(){
		MyClass test = mock(MyClass.class);
		doReturn(null).when(test).get();
		
		assertNull("is Null", test.get());
		
	}
	@Test
	public void testSpy(){
		// Lets mock a LinkedList
		List list = mock( LinkedList.class);
		//List spy = spy(list);
		

		//You have to use doReturn() for stubbing
		doReturn("foo").when(list).get(0);
		Object o= list.get(0);
		System.out.println(o.toString());
		// this would not work
		// real method is called so spy.get(0) 
		// throws IndexOutOfBoundsException (list is still empty)
		when(list.get(0)).thenReturn("foo"); 		
	}

}
