package com.javanotes2all.java.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

public class FileCompareExample 
{
//include commons-io-1.2.jar file
	//defining main function
	public static void main (String[] args) throws java.io.IOException
	{
		//Getting the name of the files to be compared.
		BufferedReader br2 = new BufferedReader (new	InputStreamReader(System.in));
		System.out.println("Enter 1st compare path name:");
		String str = br2.readLine();
		System.out.println("Enter 2nd compare path name:");
		String str1 = br2.readLine();
		FileCompareExample exp=new FileCompareExample();
		if(exp.comparePaths(str, str1)==1)
		{
			exp.getListofFiles(str, str1);
		}


	}
	//for compare the two folders
	public int comparePaths(String str1,String str2)
	{
		int i=0;
		// Create file object representing the source file/directory  
		File file = new File(str1);  

		// Create another file for comparison.  
		File file2 = new File(str2);  

		// Compare two files.  
		if(file.compareTo(file2) == 0)
		{
			System.out.println("Both paths are same!");
			i=0;
		}
		else
		{
			System.out.println("Paths are not same!");
			i=1;
		}
		return i;
	}
	public void compareFiles(String file1,String file2)throws java.io.IOException
	{

		String s1="";
		String s2="",s3="",s4="";
		String y="",z="";

		//Reading the contents of the files
		BufferedReader br = new BufferedReader (new FileReader (file1));
		BufferedReader br1 = new BufferedReader (new FileReader (file2));

		while((z=br1.readLine())!=null)
			s3+=z;

		while((y=br.readLine())!=null)
			s1+=y;

		//System.out.println ();

		//String tokenizing
		int numTokens = 0;
		StringTokenizer st = new StringTokenizer (s1);
		String[] a = new String[10000];
		for(int l=0;l<10000;l++)
		{a[l]="";}
		int i=0;
		while (st.hasMoreTokens())
		{
			s2 = st.nextToken();
			a[i]=s2;
			i++;
			numTokens++;
		}

		int numTokens1 = 0;
		StringTokenizer st1 = new StringTokenizer (s3);
		String[] b = new String[10000];
		for(int k=0;k<10000;k++)
		{b[k]="";}
		int j=0;
		while (st1.hasMoreTokens())
		{
			s4 = st1.nextToken();
			b[j]=s4;
			j++;
			numTokens1++;
		}

		//comparing the contents of the files and printing the differences, if any.
		int x=0;
		for(int m=0;m<a.length;m++)
		{
			if(a[m].equals(b[m])){}
			else
			{
				x++;
				//System.out.println(a[m] + " -- " +b[m]);
				//System.out.println();
				}
		}
		//System.out.println("No. of differences : " + x);
		if(x>0)
		{
			System.out.println(file1+" "+file2);
			System.out.println("Files are not equal");
		}
		else
		{
			//System.out.println("Files are equal. No difference found");
		}

	}
	//for getting the files list in folder
	public void getListofFiles(String path1,String path2) throws IOException
	{		 
		File dir = new File(path1);
		System.out.println("Getting all files in " + dir.getCanonicalPath() + " including those in subdirectories");
		List<File> files = (List<File>) FileUtils.listFiles(dir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
		for (File file : files) {
			if(file.getCanonicalPath().endsWith(".java")&&!file.getCanonicalPath().contains("GreetingServiceImpl")&&!file.getCanonicalPath().contains("reportMethods"))
			{
				//System.out.println("file: " + file.getCanonicalPath());
			//	System.out.println("file: " + file.getCanonicalPath().replace(path1, path2));
				compareFiles(file.getCanonicalPath(), file.getCanonicalPath().replace(path1, path2));
			}
		}
	}

}
