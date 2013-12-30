package com.javanotes2all.java.others;

import java.io.PrintStream;

public class tabspacees {

	public static void main(String[] args) {  
	    try {  
	      String titles="Emp Name:\tempname\r\n";
	      PrintStream ps = new PrintStream("/home/prabhu/tabs.txt");  
	      ps.print(titles);  
	      titles="Date:\t\tdatetime\r\n";
	      ps.print(titles);  
	    } catch(Exception e) {  
	      System.err.println(e);  
	    }  
	  }  

}
