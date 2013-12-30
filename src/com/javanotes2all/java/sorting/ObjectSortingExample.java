package com.javanotes2all.java.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ObjectSortingExample {

	public static void main(String[] args) {

		int[] integerArray = {1,0,3,2};

        Arrays.sort(integerArray);
        System.out.println(Arrays.toString(integerArray));

        String[] stringArray = {"J", "A", "V", "A", "C"};
        Arrays.sort(stringArray);
        System.out.println(Arrays.toString(stringArray));

        List<String> stringList = new ArrayList<String>();

        stringList.add("J");
        stringList.add("A");
        stringList.add("V");
        stringList.add("A");
        stringList.add("C");

        Collections.sort(stringList);
        for(String elem: stringList) 
        	System.out.print(" "+elem);
    }

}