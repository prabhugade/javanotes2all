package com.javanotes2all.java.collectionfw;

import java.util.ArrayList;

public class DeleteindexbasedeleteArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		ArrayList<String> list=new ArrayList<String>();
		list.add("0");
		list.add("2");
		list.add("1");
		System.out.println(list);
		list.remove(1);
		System.out.println(list+""+list.size()+"");
		list.add(2,"5");
		boolean t=list.remove("1");
		System.out.println(list.get(0)+list+t);

	}

}
