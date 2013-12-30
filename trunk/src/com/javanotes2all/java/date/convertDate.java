package com.javanotes2all.java.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class convertDate {

	TimeZone tz=null;	
	public convertDate()
	{
		tz=TimeZone.getDefault();
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+5:30"));
	}
	public static void main(String[] args) 
	{
		String date="06-AUG-2013";
		System.out.println("starting date="+date);
		date=new convertDate().fotmatDate(date,"dd-MMM-yyyy","yyyy-MM-dd");
		System.out.println("formated from dd-MMM-yyyy to yyyy-MM-dd format="+date);
		date=new convertDate().fotmatDate(date,"yyyy-MM-dd","dd-MMM-yyyy");
		System.out.println("again format yyyy-MM-dd to dd-MMM-yyyy format="+date);
	}
	public String fotmatDate(String date,String fromformat,String toformat)
	{
		String resultdate=null;
		Calendar calendar=Calendar.getInstance(tz);
		Date date1;
		try {
			date1 = new SimpleDateFormat(fromformat).parse(date);
			calendar.setTime(date1);
			resultdate=new SimpleDateFormat(toformat).format(calendar.getTime()); 
		} catch (ParseException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return resultdate;
	}
}
