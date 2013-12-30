package com.javanotes2all.java.others;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class GetDataFromUrl {
	public static void main(String[] args)  {
		try {
			URL my_url = new URL("http://javanotes2all.blogspot.in/2012/11/creating-zip-and-jar-files-in-java.html");
			BufferedReader br = new BufferedReader(new InputStreamReader(my_url.openStream()));
			String strTemp = "";
			while(null != (strTemp = br.readLine())){
				System.out.println(strTemp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

