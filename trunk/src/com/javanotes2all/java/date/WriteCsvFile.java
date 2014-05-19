package com.javanotes2all.java.date;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteCsvFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new WriteCsvFile().WriteData();
	}
	public void WriteData()
	{
		try
		{
				FileWriter filewriter=null;
				BufferedWriter bufwriter=null;
				filewriter=new FileWriter("/home/prabhu/Desktop/sql.txt",true);
				bufwriter=new BufferedWriter(filewriter);
				String sql="File Writer";
				bufwriter.write(sql);
				bufwriter.newLine();
				
				bufwriter.close();
				System.out.println("successfully completed");
		}
		catch(Exception e)
		{
		}
	}
}
