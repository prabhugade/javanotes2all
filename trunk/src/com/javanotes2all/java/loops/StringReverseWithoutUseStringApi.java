package com.javanotes2all.java.loops;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Stack;

public class StringReverseWithoutUseStringApi {

	public static void main(String... arg) throws IOException { 
		int c; 
		Stack s = new Stack(); 
		System.out.println("Enter the String to Reverse :"); 
		BufferedInputStream in = new BufferedInputStream(System.in); 
		while ((c = in.read()) != 10) { 
		s.push(new Character((char) c)); 
		} 
		System.out.print("String in Reverse order\n"); 
		while (!s.empty()) { 
		System.out.print(s.pop()); 

		} 
	}
}
