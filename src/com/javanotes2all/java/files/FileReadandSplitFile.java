package com.javanotes2all.java.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class FileReadandSplitFile {

	public static void main(String args[])
	  {
	  try{
	  // Open the file that is the first 
	  // command line parameter
	  String path="/home/prabhu/dms backup/just biryani/databases of js/justbiryani.sql";
	  FileInputStream fstream = new FileInputStream("/home/prabhu/dms backup/just biryani/databases of js/justbiryani.sql");
	  // Get the object of DataInputStream
	  DataInputStream in = new DataInputStream(fstream);
	  BufferedReader br = new BufferedReader(new InputStreamReader(in));
	  String strLine;
	  int count=0;
	  ArrayList<String> list=new ArrayList<String>();
	  int breakcount=100000;  //number of lines limit
	  int breakcountadd=breakcount-1;
	  //Read File Line By Line
	  while ((strLine = br.readLine()) != null)   {
		  count++;
	  // Print the content on the console
		  if(strLine.startsWith("INSERT INTO")&&count>=breakcount)
		  {
			  list.add(count-1+"");
			  breakcount=count+breakcountadd;
		  }
		 
	//  System.out.println (strLine);
	  }
	  list.add(count+"");
	  FileReadandSplitFile write=new FileReadandSplitFile();
	  Iterator<String> it=list.iterator();
	  int tocount=0;
	  int c=0;
	  while(it.hasNext())
	  {
		  int fromcount=tocount;
		  String toc=it.next();
		  tocount=Integer.parseInt(toc);
		  System.out.println(fromcount+"  "+tocount);
		  write.wirteFile("/home/prabhu/dms backup/just biryani/databases of js/justbiryani"+c+++".sql", path, fromcount, tocount,count);
		  
	  }
	  System.out.println(count/2+" "+list);
	  
	  //Close the input stream
	  in.close();
	    }catch (Exception e){//Catch exception if any
	  System.err.println("Error: " + e.getMessage());
	  }
	  }
	//for writing the file
	public void wirteFile(String file_name,String path,int fromline,int toline,int nolines)
	{
		try
		{
			BufferedReader in = new BufferedReader (new FileReader(path));
			BufferedWriter out=null;
			        String info = "";
			        FileWriter fstream = new FileWriter(file_name);
			        out = new BufferedWriter(fstream);
			        for (int i = 0; i < nolines; i++)
			        {
				        info = in.readLine();
				        if(i>=fromline&&i<toline)
				        {
				        out.write(info);
				        out.newLine();
				        }
			        }
			        out.close();
			        in.close();

		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
