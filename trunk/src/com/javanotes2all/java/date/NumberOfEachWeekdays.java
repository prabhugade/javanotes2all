package com.javanotes2all.java.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class NumberOfEachWeekdays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		try
		{
			String fromdate="2012-06-01";
			String todate="2012-06-29";
			HashMap<String,Integer> weeksmap=new HashMap<String, Integer>();
			weeksmap.put("Sunday",0);
			weeksmap.put("Monday",0);
			weeksmap.put("Tuesday",0);
			weeksmap.put("Wednesday",0);
			weeksmap.put("Thursday",0);
			weeksmap.put("Friday",0);
			weeksmap.put("Saturday",0);
			Calendar c1 = Calendar.getInstance();
			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(todate);
			c1.setTime(date1);

			Calendar c2 = Calendar.getInstance();
			Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(fromdate);
			c2.setTime(date2);
			while(c1.after(c2)) {  
				if(c2.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)  
				{
					weeksmap.put("Sunday", weeksmap.get("Sunday")+1);
				}else  if(c2.get(Calendar.DAY_OF_WEEK)==Calendar.MONDAY)  
				{
					weeksmap.put("Monday", weeksmap.get("Monday")+1);
				}else  if(c2.get(Calendar.DAY_OF_WEEK)==Calendar.TUESDAY)  
				{
					weeksmap.put("Tuesday", weeksmap.get("Tuesday")+1);
				}else  if(c2.get(Calendar.DAY_OF_WEEK)==Calendar.WEDNESDAY)  
				{
					weeksmap.put("Wednesday", weeksmap.get("Wednesday")+1);
				}else  if(c2.get(Calendar.DAY_OF_WEEK)==Calendar.THURSDAY)  
				{
					weeksmap.put("Thursday", weeksmap.get("Thursday")+1);
				}else  if(c2.get(Calendar.DAY_OF_WEEK)==Calendar.FRIDAY)  
				{
					weeksmap.put("Friday", weeksmap.get("Friday")+1);
				}else  if(c2.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY)  
				{
					weeksmap.put("Saturday", weeksmap.get("Saturday")+1);
				}
				c2.add(Calendar.DATE,1);  
			}  
			System.out.println(weeksmap);
		}catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
   
        
	}

}
