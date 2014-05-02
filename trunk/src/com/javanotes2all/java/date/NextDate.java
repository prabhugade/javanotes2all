package com.javanotes2all.java.date;

import java.util.Calendar;
import java.util.Date;

public class NextDate {

	public static void main(String[] args) {
		Date aDate = new Date();
	    Calendar with = Calendar.getInstance();
	    with.setTime(aDate);
	    System.out.println(with.getTime());
	    with.add(Calendar.DATE, 1);
	    System.out.println(with.getTime());
	}

}
