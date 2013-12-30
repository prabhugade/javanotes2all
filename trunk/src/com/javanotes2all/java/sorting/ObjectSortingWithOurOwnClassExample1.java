package com.javanotes2all.java.sorting;

import java.util.Arrays;

public class ObjectSortingWithOurOwnClassExample1 
{
	public static void main(String[] args) {

		Student1[] studentArray = new Student1[3];
		studentArray[0] = new Student1(1, "abc",1);
		studentArray[1] = new Student1(5, "xyz", 4);
		studentArray[2] = new Student1(4, "pqr", 5);

		Arrays.sort(studentArray);
		System.out.println(Arrays.toString(studentArray));
	}
}
