package com.javanotes2all.java.loops;

public class SwapingTwoNumbers {

	public static void main(String[] args) 
	{
		int a=20,b=10;
		System.out.println("before swaping a="+a+" b="+b);
		//approch 1
		a = a+b; 
		b= a-b; 
		a=a-b;
		System.out.println("after swaping a="+a+" b="+b);
		
		//approch 2
		a = a*b; 
		b=a/b; 
		a=a/b;
		System.out.println("after swaping a="+a+" b="+b);
		
		a^=b;
		b^=a;
		a^=b;
		System.out.println("after swaping a="+a+" b="+b);
	}

}
