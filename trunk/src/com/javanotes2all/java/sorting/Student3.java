package com.javanotes2all.java.sorting;

import java.util.Comparator;

public class Student3 implements Comparable<Student3> {

	private int id;
	private String name;
	private int currentYearOfStudy;

	public Student3(int id, String name, int currYearOfStudy) {
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
	public int compareTo(Student3 stud) {
		return (this.id - stud.id);
	}

	public static Comparator<Student3> idComperator = new Comparator<Student3>() {

		@Override
		public int compare(Student3 st1, Student3 st2) {
			return (int) (st1.getId() - st2.getId());
		}
	};

	public static Comparator<Student3> currentYearComperator = new Comparator<Student3>() {

		@Override
		public int compare(Student3 st1, Student3 st2) {
			return (int) (st1.getCurrentYearOfStudy() - st2
					.getCurrentYearOfStudy());
		}
	};

	public static Comparator<Student3> currentYearandNameComperator = new Comparator<Student3>() {

		@Override
		public int compare(Student3 st1, Student3 st2) {
			int retval = (int) (st1.getCurrentYearOfStudy() - st2.getCurrentYearOfStudy());
			if (retval == 0) {
				retval = (int) (st1.getName().compareTo(st2.getName()));
			}
			return retval;
		}
	};

}
