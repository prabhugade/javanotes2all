package com.javanotes2all.java.string;

public class Split_String 
{
	public static void main(String[] args) 
	{
		String s="com.javanotes2all_$_java.developer";
		/**
		 * Split with characters 
		 */
		System.out.println("=============split using single special character");
		String[] s1=s.split("\\.");
		System.out.println("array length:="+s1.length);
		for(int i=0;i<s1.length;i++)
			System.out.println(s1[i]);
		
		/**
		 * Split with numbers 
		 */
		System.out.println("==============split using multiple special characters");
		String[] s2=s.split("\\_\\$\\_");
		System.out.println("array length:="+s2.length);
		for(int i=0;i<s2.length;i++)
			System.out.println(s2[i]);
		
	}

}
