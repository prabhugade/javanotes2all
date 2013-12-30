package com.javanotes2all.java.date;

import java.util.Calendar;

public class GetMaxDaysOfMonth {

	public static void main(String[] args) {
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2013);
		calendar.set(Calendar.MONTH, 10);
		calendar.set(Calendar.DATE, 1);
		System.out.println(calendar.getTime().toString());
		int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(days);
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
	}

}
