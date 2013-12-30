package com.javanotes2all.java.sorting;

import java.util.Comparator;

public class Student2 implements Comparable<Student2> {

	private int id;
	private String name;
	private int currentYearOfStudy;

	public Student2(int id, String name, int currYearOfStudy) {
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
	public int compareTo(Student2 stud) {
		return (this.id - stud.id);
	}

	public static Comparator<Student2> idComperator = new Comparator<Student2>() {

		@Override
		public int compare(Student2 st1, Student2 st2) {
			return (int) (st1.getId() - st2.getId());
		}
	};

	public static Comparator<Student2> currentYearComperator = new Comparator<Student2>() {

		@Override
		public int compare(Student2 st1, Student2 st2) {
			return (int) (st1.getCurrentYearOfStudy() - st2.getCurrentYearOfStudy());
		}
	};

}