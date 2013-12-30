package com.javanotes2all.java.system;

public class GarbageCollector {

	public void finalize()
	{
		System.out.println("object collected");
	}
	
	public static void main(String[] args) 
	{
		GarbageCollector gc1=new GarbageCollector();
		GarbageCollector gc2=new GarbageCollector();
		gc1=null;
		gc2=null;
		System.gc();

	}

}
