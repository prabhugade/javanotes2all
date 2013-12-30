package com.javanotes2all.java.inheritence;

public class Multipleinheritence implements interface1,interface2 { 
	@Override 
	public int name() { 
		System.out.println("HI"); 
		return 1; 
	} 
	@Override 
	public String name() { 
		System.out.println("HI"); 
		return ""; 
	} 
	public static void main(String[] args) { 
		System.out.println(); 
		Multipleinheritence m= new Multipleinheritence(); 
		m.name(); 
	} 
} 
interface interface1{ 
public int name(); 
} 
interface interface2{ 
public String name();	
}