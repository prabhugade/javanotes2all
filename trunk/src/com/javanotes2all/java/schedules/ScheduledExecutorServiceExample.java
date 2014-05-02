package com.javanotes2all.java.schedules;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceExample {

	
	public static void main(String[] args) {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	    scheduler.scheduleWithFixedDelay(new task1(), 1, 2, TimeUnit.MINUTES);
	    scheduler.scheduleWithFixedDelay(new task2(), 1, 1, TimeUnit.MINUTES);
	}
}
class task1 implements Runnable
{
	@Override
	public void run() {
		System.out.println("task1 running");
		
	}
	
}
class task2 implements Runnable
{
	@Override
	public void run() {
		System.out.println("task2 running");
		
	}
	
}
