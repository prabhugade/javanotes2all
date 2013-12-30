package com.javanotes2all.java.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class getWeekfromdate
{
	public static void main(String[] args) 
	{
		try
		{
		String fromdate="2012-06-22 00:00:01";
		String todate="2012-06-29 10:36:08";
		HashMap<String,String> weeksmap=new HashMap<String, String>();
		weeksmap.put("1", "Sunday");
		weeksmap.put("2", "Monday");
		weeksmap.put("3", "Tuesday");
		weeksmap.put("4", "Wednesday");
		weeksmap.put("5", "Thursday");
		weeksmap.put("6", "Friday");
		weeksmap.put("7", "Saturday");
		
		while(Double.parseDouble(fromdate.substring(0,10).replaceAll("[^0-9]+", ""))<Double.parseDouble(todate.substring(0,10).replaceAll("[^0-9]+", "")))
		{
		Calendar calendar = Calendar.getInstance();
		Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fromdate);
		calendar.setTime(date1);
		System.out.print(fromdate);
		int i=calendar.get(Calendar.DAY_OF_WEEK);
		System.out.print("    "+i+"  ");
		System.out.println("           "+weeksmap.get(i+""));
		calendar.add(Calendar.DATE, 1);
		String nextdate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
		fromdate=nextdate;
		}
		}catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}

}
