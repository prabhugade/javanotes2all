package com.javanotes2all.java.sorting;

import java.util.Arrays;

public class ObjectSortingWithOurOwnClassExample2 
{
	public static void main(String[] args) {

		Student2[] studentArray = new Student2[3];
		studentArray[0] = new Student2(1, "abc",1);
		studentArray[1] = new Student2(5, "xyz", 4);
		studentArray[2] = new Student2(4, "abc", 5);

		Arrays.sort(studentArray, Student2.idComperator);
		System.out.println("Using id as key :"+ Arrays.toString(studentArray));

		Arrays.sort(studentArray, Student2.currentYearComperator);
		System.out.println("Using Current Year of Study as key :"+Arrays.toString(studentArray));

	}
}
