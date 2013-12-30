package com.javanotes2all.java.reqRes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class CallUrl 
{
	 public static void main(String[] args) 
	 {
	        URL url;
	        try 
	        {
	            // get URL content
	            String a="http://docs.oracle.com/javase/tutorial/jdbc/basics/sqldatasources.html";
	            url = new URL(a);
	            URLConnection conn = url.openConnection();
	            // open the stream and put it into BufferedReader
	            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            String inputLine;
	            while ((inputLine = br.readLine()) != null) {
	                    System.out.println(inputLine);
	            }
	            br.close();

	            System.out.println("Done");

	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    }

}
