package com.javanotes2all.java.loops;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.logging.Logger;

public class PrintWithoutprint {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		approach1();
		approach2();
		approach3();
		approach4();
	}

	public static void approach1() throws IOException
	{
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out)); 

		for(int i=1; i<=10; i++){ 
		out.write(i + "\n"); 
		} 
		out.flush(); 
	}
	
	public static void approach2()
	{
			PrintStream p = System.out; 
			p.println("approach2"); 
	}
	public static void approach3()
	{
		Logger log = Logger.getLogger("");
		String count ="1 \n 2 \n 3 \n 4 \n 5 \n 6 \n 7 \n 8 \n 9 \n 10 \n";
		log.info(count );
	}
	public static void approach4()
	{
		try{ 
			String message=""; 
			for (int i=1;i<=10;i++) 
			message+=String.valueOf(i)+" "; 
			throw new Exception(message); 
			}catch(Exception e){ 
			e.printStackTrace(); 
			}
	}
}
