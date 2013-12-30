package com.javanotes2all.java.files;

import java.io.File;

public class FindSizeOfFile 
{

	public static void main(String[] args)
	{
		File file= new File("/home/prabhu/dms.war");
		long size =0;
		size=getSize(file);

		// Convert the size in bytes to mega bytes/Killo bytes.

		double sizeInMB =(double)size / 1024 / 1024;
		String s="MB";
		if(sizeInMB<1)
		{
			sizeInMB=(double)size / 1024;
			s="KB";
		}

		System.out.println(file.getName()+":"+sizeInMB+s);	

	}	
	public static long getSize(File dir) {
		long size = 0;
		if(dir.isDirectory())
		{
			for (File file : dir.listFiles()) {
				if (file.isFile()) {
					size += file.length();
				}
				else
					size += getSize(file);
			}
		}else if(dir.isFile())
		{
			size += dir.length();
		}
		return size;
	}

}
