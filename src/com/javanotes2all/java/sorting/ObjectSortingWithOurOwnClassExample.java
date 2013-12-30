package com.javanotes2all.java.sorting;

import java.util.Arrays;

public class ObjectSortingWithOurOwnClassExample 
{
//exception method
	public static void main(String[] args) {

		Student[] studentArray = new Student[3];
		studentArray[0] = new Student(1, "Nikos",1);
		studentArray[1] = new Student(5, "Ilias", 4);
		studentArray[2] = new Student(4, "Byron", 5);

		Arrays.sort(studentArray);
		System.out.println(Arrays.toString(studentArray));

	}

}