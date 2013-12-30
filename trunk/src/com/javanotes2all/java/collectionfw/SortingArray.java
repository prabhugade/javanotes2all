package com.javanotes2all.java.collectionfw;

public class SortingArray 
{
public String sortArray(String s,String d)
{
	String result=null;
	String[] array=s.split(d);
	java.util.Arrays.sort(array);
	for(int i=0;i<array.length;i++)
	{
		if(i==0)
			result=array[i];
		else
			result=result+d+array[i];
	}
	return result;
}
}
