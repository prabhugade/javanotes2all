package com.javanotes2all.java.collectionfw;

import java.util.ArrayList;

public class Arraylist_Integers {

	public static void main(String[] args) {
		ArrayList<Integer> al=new ArrayList<Integer>();
		al.add(3);
		al.add(2);
		al.add(4);
		al.add(5);
		al.add(1);
		System.out.println(al);
		/*
		 * If we want to delete index value
		 */
		al.remove(1);
		System.out.println(al);
		
		/*
		 * If we want to delete object value
		 */
		al.remove((Integer)1);
		System.out.println(al);
	}

}
