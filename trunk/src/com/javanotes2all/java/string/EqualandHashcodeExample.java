package com.javanotes2all.java.string;

public class EqualandHashcodeExample 
{
	public static void main(String[] args)
	{
		String s="abc";
		String s1=new String("abc");
		System.out.println("s and s1 equals are: "+(s.equals(s1)));
		System.out.println("s and s1 = are: "+(s==s1));
		System.out.println("s hashcode is: "+s.hashCode());
		System.out.println("s1 hashcode is: "+s1.hashCode());
	}
}
