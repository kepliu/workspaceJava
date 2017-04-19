package com.drdobbs;

import java.util.Arrays;

public class ArraySorter {
	

	public static void main(String[] args) {
		String [] words = {"123", "12345", "12"};
		Arrays.sort( words, (first, second) -> Integer.compare(first.length(), second.length()));
		
		for (String w: words){
			System.out.print(w + " ");
		}
		
		

	}

}
