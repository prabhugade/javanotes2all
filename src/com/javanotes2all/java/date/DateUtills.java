package com.javanotes2all.java.date;

import java.util.Calendar;
import java.util.TimeZone;

public class DateUtills {
	public static TimeZone getTimeZones()
	{
		TimeZone tz=null;
		try
		{
			tz=TimeZone.getDefault();
			TimeZone.setDefault(TimeZone.getTimeZone("GMT+5:30"));
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return tz;
	}
	public static void main(String[] args) {
	    Calendar date = Calendar.getInstance(getTimeZones());
	    System.out.println(date.getTime());
	    //Hour of the date
	    int hour = date.get(Calendar.HOUR_OF_DAY);
	    System.out.println(hour);
	    
	}

}
