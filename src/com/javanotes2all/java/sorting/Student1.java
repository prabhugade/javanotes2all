package com.javanotes2all.java.sorting;

public class Student1  implements Comparable<Student1> {

	private int id;
	private String name;
	private int currentYearOfStudy;

	public Student1(int id, String name, int currYearOfStudy) {
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

	@Override
	public String toString() {
		return "[id=" + this.id + ", name=" + this.name
				+ ", Current Year of Study=" + this.currentYearOfStudy + "]";
	}

	@Override
	public int compareTo(Student1 stud) {
		return (this.id - stud.id);
	}
}