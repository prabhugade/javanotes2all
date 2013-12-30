package com.javanotes2all.java.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;

public class AudioAppender 
{
	public static void main(String args[]) throws IOException
    {
       BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
       System.out.println("enter path");
       String path=reader.readLine();
       AudioAppender apend=new AudioAppender();
       apend.getfilesFolder(path);
       
    }
	public void getfilesFolder(String path)
	{
		try
		{
			File dir=new File(path);
			if(dir.isDirectory())
			{
				for (File file : dir.listFiles()) 
				{
				 if (file.isFile()) 
				  {
					if(file.getPath().contains("(1)"))
					 {
							String sourcefile=path+"/"+file.getName().replace(" (1)", "");
							String sourcefile1=file.getPath();
							String outpath=path+"/"+file.getName().replace(" (1)", "-2");
							merge(sourcefile, sourcefile1, outpath);
					 }
				  }				     
				}
				System.out.println("appended successfully");
			}else 
				System.out.println("it is not a folder");
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public void merge(String path1,String path2,String path3) throws IOException
    {
        FileInputStream fistream1 = new FileInputStream(path1);  // first source file
        FileInputStream fistream2 = new FileInputStream(path2);//second source file
        SequenceInputStream sistream = new SequenceInputStream(fistream1, fistream2);
        FileOutputStream fostream = new FileOutputStream(path3);//destinationfile
        int temp;
        while( ( temp = sistream.read() ) != -1)
        {
            fostream.write(temp);   // to write to file
        }
        fostream.close();
        sistream.close();
        fistream1.close();
        fistream2.close();
        System.out.println(path1+" completed");
    }

}
