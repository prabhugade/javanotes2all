package com.javanotes2all.java.collectionfw;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;

public class compareTwoArraylists {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//import org.apache.commons.collections.CollectionUtils;
		ArrayList<Integer> firstList = new ArrayList<Integer>();  
	    firstList.add(1);  
	    firstList.add(2);  
	    firstList.add(3);  
	    firstList.add(4);  
	    ArrayList<Integer> secondList = new ArrayList<Integer>();  
	    secondList.add(1);  
	    secondList.add(2);  
	    secondList.add(3);  
	    secondList.add(4);  
	    Collection disJointList = CollectionUtils.disjunction(firstList, secondList); 
	    Collection interJointList = CollectionUtils.intersection(firstList, secondList); 
	    
	    System.out.println(disJointList);  
	    
	    System.out.println(interJointList);
	    
	    System.out.println(firstList.equals(secondList));
	    
	    ArrayList<String> firstList1 = new ArrayList<String>();  
	    firstList1.add("abc");  
	    firstList1.add("p");  
	    firstList1.add("q");  
	    firstList1.add("r");  
	    ArrayList<String> secondList1 = new ArrayList<String>();  
	    secondList1.add("abc");  
	    secondList1.add("p");  
	    secondList1.add("q");  
	    secondList1.add("r");  
	   
	    
	    System.out.println(firstList1.equals(secondList1));
	}

}
