package com.javanotes2all.java.sorting;

import java.util.Arrays;

public class ObjectSortingWithOurOwnClassExample3 {

	public static void main(String[] args) {

		Student3[] studentArray = new Student3[3];
		studentArray[0] = new Student3(1, "Nikos",5);
		studentArray[1] = new Student3(5, "Ilias", 4);
		studentArray[2] = new Student3(4, "Byron", 4);

		Arrays.sort(studentArray, Student3.currentYearandNameComperator);
		System.out.println("Using Current Year and Name as key :"+ Arrays.toString(studentArray));	
	}
}