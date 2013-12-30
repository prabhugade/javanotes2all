package com.javanotes2all.java.performance;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
 
public class ForLoopPerformanceTest
{
    private static List<Integer> list = new ArrayList<Integer>();
    private static long startTime;
    private static long endTime;
    static
    {
        for(int i=0; i < 10000000; i++)
        {
            list.add(i);
        }
    }
    @SuppressWarnings("unused")
    public static void main(String[] args)
    {
        //Type 1
        startTime = Calendar.getInstance().getTimeInMillis();
        for(Integer i : list)
        {
            //
        }
        endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("For each loop :: " + (endTime - startTime) + " ms");
 
        //Type 2
        startTime = Calendar.getInstance().getTimeInMillis();
        for(int j = 0; j < list.size() ; j++)
        {
            //
        }
        endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("Using collection.size() :: " + (endTime - startTime) + " ms");
 
        //Type 3
        startTime = Calendar.getInstance().getTimeInMillis();
        int size = list.size();
        for(int j = 0; j < size ; j++)
        {
            //System.out.println(j);
        }
        endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("Using [int size = list.size(); int j = 0; j < size ; j++] :: " + (endTime - startTime) + " ms");
 
        //Type 4
        startTime = Calendar.getInstance().getTimeInMillis();
        for(int j = list.size(); j > size ; j--)
        {
            //System.out.println(j);
        }
        endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("Using [int j = list.size(); j > size ; j--] :: " + (endTime - startTime) + " ms");
        
        /*
         Reason for difference in performance

Last two flavors type 3 and 4 have a very little difference and should be considered as same. They both fetch the size of collection initially. And then uses this size value in loop for checking the condition.

Type 2 uses size() method call every time and thus on runtime it brings a little overhead. Though JVM optimizes this code as inline call and other optimizations also and size method is simply a getter for size attribute of instance of list. Even though it brings a few more statements to execute at machine level code and which makes the difference.

Type 1 is costliest one and simple reasoning is the use of iterator internally created in for each loop. Creating an iterator and calling iterator.get() adds up to most of cost which is not involved in direct access in other three types.
         */
    }
}