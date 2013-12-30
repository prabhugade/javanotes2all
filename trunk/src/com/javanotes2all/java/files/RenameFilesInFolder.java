package com.javanotes2all.java.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class RenameFilesInFolder 
{
	public static void main(String[] args) throws IOException 
	{
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter Folder name");
		String folder=reader.readLine();
		System.out.println("enter Find");
		String find=reader.readLine();
		System.out.println("enter replace With");
		String replace=reader.readLine();
		try
		{
			File dir=new File(folder);
			if(dir.isDirectory())
			{
				for (File file : dir.listFiles()) 
				{
				 if (file.isFile()) 
				  {
					 String filename=file.getName();
					 String path=file.getPath();
					 System.out.println(filename+" "+path);
					 if(filename.contains(find))
					 {
						 String newfile=folder+"/"+filename.replace(find, replace);
						 file.renameTo(new File(newfile));
					 }
				  }				     
				}
			}else 
				System.out.println("it is not a folder");

		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
