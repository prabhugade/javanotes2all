package com.javanotes2all.java.string;

public class CaseInsesitiveReplace 
{
	public static void main(String[] args) 
	{
		//case sensitive replace
		String target = "FooBar";
	    target = target.replaceAll("foo", "");
	    System.out.println(target); 
	    
	    //case insensitive replace
		target = "FooBar";
	    target = target.replaceAll("(?i)foo", "");
	    System.out.println(target);
	}

}
