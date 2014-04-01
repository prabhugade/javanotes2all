package com.javanotes2all.java.loops;

import java.util.Arrays;

public class FindSecondHighestnumber {

	public static void main(String[] args) {
		int[] array={1,3,5,0,6,9};
		
		Arrays.sort(array);
		System.out.println(array[array.length-2]);
	}

}
