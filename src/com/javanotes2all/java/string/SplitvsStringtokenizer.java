package com.javanotes2all.java.string;

import java.util.StringTokenizer;

public class SplitvsStringtokenizer {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/* Example 1 - The constructor StringTokenizer(String), 
		 * it use the default delimiter set such as the space character " ", 
		 * the tab character "\t", the newline character "\n", 
		 * the carriage-return character "\r" 
		 * AND the form-feed character "\f" but delimiter characters itself will not be treated as tokens.*/
		System.out.println("StringTokenizer Example in Java, split String on whitespace");

        String word = "Which one is better\nStringTokenizer vs Split?";
        StringTokenizer tokenizer = new StringTokenizer(word);
        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }


        // Example 2 - StringTokenizer with multiple delimiter
        System.out.println("StringTokenizer multiple delimiter Example in Java");

        String msg = "http://192.173.15.36:8084/";
        StringTokenizer st = new StringTokenizer(msg, "://.");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
        //It takes only first delimeter
        String[] strings=msg.split("://.");
        for(int p=0;p<strings.length;p++)
        {
        	System.out.println(strings[p]);
        }
        
        //It takes all together as one delimeter
        strings=msg.split("\\:\\/\\/\\.");
        for(int p=0;p<strings.length;p++)
        {
        	System.out.println(strings[p]);
        }
	}

}
