package com.javanotes2all.java.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileWrite
{
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
