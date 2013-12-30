package com.javanotes2all.java.string;

public class RegulerExpresion {

	public static void main(String[] args) 
	{
		String s="1234123,123213213,123123,123123,123123,123123";
		if(s.trim().matches("[0-9]+(,[0-9]+)*"))
		{
			System.out.println("valid string");
		}else
			System.out.println("invalid string");
	}
}
