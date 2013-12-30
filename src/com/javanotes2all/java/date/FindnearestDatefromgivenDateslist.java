package com.javanotes2all.java.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.TreeSet;

public class FindnearestDatefromgivenDateslist {

	static TimeZone tz=null;	
	public FindnearestDatefromgivenDateslist()
	{
		tz=TimeZone.getDefault();
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+5:30"));
	}
	public static void main(String[] args) 
	{
		ArrayList<Date> list=new ArrayList<Date>();
		Date date1;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2013-12-01");
			list.add(date1);
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2013-12-03");
			list.add(date1);
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2013-12-04");
			list.add(date1);
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2013-12-07");
			list.add(date1);
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2013-12-05");
			list.add(date1);
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2013-12-06");
			System.out.println(new FindnearestDatefromgivenDateslist().getDateNearest(list, date1));
		} catch (ParseException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	private Date getDateNearest(List<Date> dates, Date targetDate)
	{
		return new TreeSet<Date>(dates).lower(targetDate);
	}
}
