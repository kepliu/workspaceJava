package com.journaldev;

public class Fibonacci {
	//public Fibonacci(int expected, int actual)
	
	public   int compute(int n){
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return compute(n-2) + compute(n-1); 
	}

}
