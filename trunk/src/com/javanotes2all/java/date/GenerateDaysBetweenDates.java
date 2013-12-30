package com.javanotes2all.java.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class GenerateDaysBetweenDates 
{
	TimeZone tz=null;	
	public GenerateDaysBetweenDates()
	{
		tz=TimeZone.getDefault();
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+5:30"));
	}
	public static void main(String[] args) 
	{
		System.out.println(new GenerateDaysBetweenDates().getBetweenDates("2013-12-01", "2013-12-15", "yyyy-MM-dd"));
	}
	public ArrayList<String> getBetweenDates(String fromdate,String todate,String format)
	{
		ArrayList<String> resultlist=new ArrayList<String>();
		try 
		{
			if(fromdate==todate)
			{
				resultlist.add(fromdate);
			}else if((todate.compareToIgnoreCase(fromdate))>0)
			{
				resultlist.add(fromdate);
				String nextdate=nextDate(fromdate, format);
				while(todate.compareToIgnoreCase(nextdate)>=0)
				{
					resultlist.add(nextdate);
					nextdate=nextDate(nextdate, format);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultlist;
	}
	public String nextDate(String date,String format)
	{
		String resultdate=null;
		Calendar calendar=Calendar.getInstance(tz);
		Date date1;
		try {
			//System.out.println(date);
			date1 = new SimpleDateFormat(format).parse(date);
			calendar.setTime(date1);
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			resultdate=new SimpleDateFormat(format).format(calendar.getTime()); 
		} catch (ParseException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return resultdate;
	}
}
