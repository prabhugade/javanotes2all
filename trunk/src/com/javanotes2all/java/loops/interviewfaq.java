package com.javanotes2all.java.loops;

import java.util.Arrays;


public class interviewfaq {

	public static void main(String[] args) 
	{
		//faq1---find second largest number
		int[] k={1,3,5,7,2,4,8};
		Arrays.sort(k);
		System.out.println(k[k.length-2]);
		
		//faq2----trim the spaces
		String s="this is  java   notes to     all";
		while(s.contains("  "))
			s=s.replace("  ", " ");
		System.out.println(s.replace("  ", " "));
		
		//faq3----find the numbers contains 9 in given range
		int n=100;
		for(int p=0;p<=n;p++)
			if((p+"").contains("9"))
				System.out.println(p);
		
		//faq4----reverse the each individual string
		//approach1
		s="javanotes 2 all";
		String[] sarray=s.split(" ");
		String tempvalue="";
		for(int p=0;p<sarray.length;p++)
		{
			String temp=sarray[p];
			int z=temp.length()-1;
			for(int q=z;q>=0;q--)
			{
				tempvalue+=temp.substring(q,q+1);
			}
			tempvalue+=" ";
		}
		System.out.println(tempvalue);
		
		//approach2
		s="javanotes 2 all";
		sarray=s.split(" ");
		tempvalue="";
		for(int p=0;p<sarray.length;p++)
		{
			String temp=new StringBuffer(sarray[p]).reverse().toString();
			tempvalue+=temp+" ";
		}
		System.out.println(tempvalue);
		
		System.out.println("math value for -ve============================");
		int value=-9;
		System.out.println(Math.sqrt(value));
		
	}
}
