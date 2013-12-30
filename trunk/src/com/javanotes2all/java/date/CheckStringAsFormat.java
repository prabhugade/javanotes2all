package com.javanotes2all.java.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckStringAsFormat {

	public static void main(String[] args) 
	{
		Date d=tryToParse("2013-12-06 00:00:00", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		if(d!=null)
			System.out.println("currect format"+d);
		else
			System.out.println("incorrect fromat");
		
		System.out.println(new DateValidator().validate("2013-06-31 23:59:01"));

	}
	 public static Date tryToParse(String input, SimpleDateFormat format) 
	 {
	         Date date  = null;
	         try {
	             date = format.parse(input);
	         } catch (Exception e) {

	         }
	         return date;
	 }
	  
	 
}
