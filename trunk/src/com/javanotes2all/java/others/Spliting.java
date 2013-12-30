package com.javanotes2all.java.others;

import java.util.StringTokenizer;

public class Spliting {

	
	public static void main(String[] args) 
	{
		String ar="abc_$_pqr_z$x__p";
		System.out.println(ar.split("$"));
		
		StringTokenizer itemtokenizer=new StringTokenizer(ar,"_$_");
		while(itemtokenizer.hasMoreElements())
		{
			System.out.println(itemtokenizer.nextElement());
		}
	}

}
