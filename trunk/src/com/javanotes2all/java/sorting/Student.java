package com.javanotes2all.java.sorting;

public class Student 
{
	private int id;
	private String name;
	private int currentYearOfStudy;

	public Student(int id, String name, int currYearOfStudy) {
		this.id = id;
		this.name = name;
		this.currentYearOfStudy = currYearOfStudy;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public int getCurrentYearOfStudy() {
		return this.currentYearOfStudy;
	}

}