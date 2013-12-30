package com.javanotes2all.java.performance;
import java.util.Arrays;


	public class Test
	{
	    public static void main(String args[])
	    {
	        long start = 0;
	        int size = 100000;
	        String[] strings = new String[size];

	        for (int i = 0; i < size; i++)
	                strings[i] = "" + i;

	        start = System.currentTimeMillis();
	        Arrays.sort(strings);
	        System.out.println("Sort : " + (System.currentTimeMillis() - start));
	        System.out.println(Arrays.binarySearch(strings, "" + (size - 1) ));
	        System.out.println("Sort & Search : " + (System.currentTimeMillis() - start));

	        start = System.currentTimeMillis();
	        System.out.println(Arrays.binarySearch(strings, "" + (size - 1) ));
	        System.out.println("Search        : " + (System.currentTimeMillis() - start));

	        start = System.currentTimeMillis();
	        System.out.println(Arrays.asList(strings).contains( "" + ("99999") ));
	        System.out.println("Contains      : " + (System.currentTimeMillis() - start));
	    
	        start = System.currentTimeMillis();
	        for(int i=0;i<size;i++)
	        {
	        	if(strings[i].equals("99999"))
	        	System.out.println(i);
	        }
	        System.out.println("Contains 1      : " + (System.currentTimeMillis() - start));
	    }
	}
