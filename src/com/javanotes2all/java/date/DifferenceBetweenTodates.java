package com.javanotes2all.java.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DifferenceBetweenTodates {

	
	public static void main(String[] args) throws Exception 
	{
		String date1 = "08/02/2013 00:00:00";
		String date2 = "08/02/2013 00:00:01";
		String format = "dd/MM/yyyy HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date dateObj1 = sdf.parse(date1);
		Date dateObj2 = sdf.parse(date2);
		long diff = dateObj2.getTime() - dateObj1.getTime();
		
		System.out.println(dateObj1+" "+dateObj2);
		
		int diffDays =  (int) (diff / (24 * 60 * 60* 1000));
		System.out.println("difference between days "+diffDays);
		
		int diffhours =  (int) (diff / ( 60 * 60* 1000));
		System.out.println("difference between hours "+diffhours);
		
		int diffmin =  (int) (diff / ( 60* 1000));
		System.out.println("difference between minitues "+diffmin);
		
		int diffsec =  (int) (diff / ( 1000));
		System.out.println("difference between seconds "+diffsec);
		
		System.out.println("difference between miliseconds "+diff);
		
	}

}
