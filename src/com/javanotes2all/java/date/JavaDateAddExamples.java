package com.javanotes2all.java.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaDateAddExamples
{
  public static void main(String[] args)
  {
    // get a calendar instance at December 31, 2009, at 11:30 p.m.
    // this way we can test that we are rolling over to the next hour,
    // tomorrow, next week, and next year properly.
    Calendar calendar = Calendar.getInstance();
    
    // get a Date instance to represent "now" (the current date);
    // we'll need it to reset our calendar during the following date examples.
    Date currentDate = calendar.getTime();
    System.out.format("today:      %s\n", currentDate);
 
    // get the date/time one hour from now
    calendar.setTime(currentDate);
    calendar.add(Calendar.HOUR_OF_DAY, 1);
    Date oneHour = calendar.getTime();
    System.out.format("one hour:   %s\n", oneHour);
    
    // get tomorrow's date
    calendar.setTime(currentDate);
    calendar.add(Calendar.DAY_OF_YEAR, 1);
    Date tomorrow = calendar.getTime();
    System.out.format("tomorrow:   %s\n", tomorrow);
    
    // get next week's date
    // note: may want to use WEEK_OF_MONTH or WEEK_OF_YEAR
    calendar.setTime(currentDate);
    calendar.add(Calendar.DAY_OF_YEAR, 7);
    Date nextWeek = calendar.getTime();
    System.out.format("next week:  %s\n", nextWeek);
  
    // get next month
    calendar.setTime(currentDate);
    calendar.add(Calendar.MONTH, 1);
    Date nextMonth = calendar.getTime();
    System.out.format("next month: %s\n", nextMonth);
  
    // get next year
    calendar.setTime(currentDate);
    calendar.add(Calendar.YEAR, 1);
    Date nextYear = calendar.getTime();
    System.out.format("next year:  %s\n", nextYear);
    
 // get next year
    calendar.setTime(currentDate);
    System.out.format("next year:  %s\n", calendar.getTime());
    calendar.add(Calendar.MINUTE, -5);
    Date nextminite = calendar.getTime();
    System.out.format("next year:  %s\n", nextminite);
    calendar.add(Calendar.MINUTE, 10);
    Date nextminite1 = calendar.getTime();
    System.out.format("next year:  %s\n", nextminite1);
    
    String startcurdate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
    System.out.println("string date:"+startcurdate);
    try {
		Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startcurdate);
		 calendar.setTime(date1);
		    System.out.format("st:  %s\n", calendar.getTime());
		    calendar.add(Calendar.DAY_OF_YEAR, 1);
		    String fstartcurdate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());  
		    System.out.println(fstartcurdate);
		    
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
    
  }
}