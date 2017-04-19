import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	static void mySub(List<? extends Animal> myList) {
		//Animal b = new Animal();
	    //myList.add(b);
	    Animal a = myList.get(0);
	}
	static long sum(Number[] numbers) {
		   long summation = 0;
		   for(Number number : numbers) {
		      summation += number.longValue();
		   }
		   return summation;
		}
	static long sumList(List<? extends Number> numbers) {
		   long summation = 0;
		   for(Number number : numbers) {
		      summation += number.longValue();
		   }
		   return summation;
		}
	public static void copy(List<? extends Number> source, List<? super Number> destiny) {
	    for(Number number : source) {
	        destiny.add(number);
	    }
	}
	public static void main(String[] args) {
		List<Dog> animals = new ArrayList<Dog>();
		animals.add(new Dog());
		mySub(animals);
		Integer[] myInts = {1,2,3,4};
		Number[] myNumber = myInts;
		//myNumber[0] = 3.14; //run time error: attempt of heap pollution
		
		List<Integer> myInts1 = new ArrayList<Integer>();
		myInts1.add(1);
		myInts1.add(2);

		//List<Number> myNums = myInts; //compiler error
		//myNums.add(3.14); //heap polution
		testSum();
		testSumList();
		testCopy();

		
		
	      Set s = new TreeSet<Integer>();
	      Set<String> ss = s;            // unchecked warning
	      s.add(new Integer(42));        // another unchecked warning
	      Iterator<String> iter = ss.iterator();
	      while (iter.hasNext())
	      {
	         String str = iter.next();   // ClassCastException thrown
	         System.out.println(str);
	      }
	}
	private static void testCopy() {
		List<Integer> myInts = Arrays.asList(1,2,3,4);
		List<Double> myDoubles = Arrays.asList(3.14, 6.28);
		List<Object> myObjs = new ArrayList<Object>();

		copy(myInts, myObjs);
		copy(myDoubles, myObjs);	
	}
	private static void testSum() {
		Integer[] myInts = {1,2,3,4,5};
		Long[] myLongs = {1L, 2L, 3L, 4L, 5L};
		Double[] myDoubles = {1.0, 2.1, 3.0, 4.0, 5.0};

		System.out.println(sum(myInts));
		System.out.println(sum(myLongs));
		System.out.println(sum(myDoubles));		
	}
	private static void testSumList(){
		List<Integer> myInts = Arrays.asList(1,2,3,4,5);
		List<Long> myLongs = Arrays.asList(1L, 2L, 3L, 4L, 5L);
		List<Double> myDoubles = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);

		System.out.println(sumList(myInts)); //compiler error
		System.out.println(sumList(myLongs)); //compiler error
		System.out.println(sumList(myDoubles)); //compiler error
	}

}
