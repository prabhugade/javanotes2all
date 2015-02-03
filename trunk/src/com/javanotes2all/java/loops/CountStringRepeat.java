package com.javanotes2all.java.loops;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountStringRepeat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(countOccurance("the","The quick brown fox jumps over thea lazy dog"));
		System.out.println(countOccurance1("the","The quick brown fox jumps over thea lazy dog"));

	}
	public static int countOccurance (String word, String sentence) { 
		int count = 0; 
		for (int i = 0; i != sentence.length()-word.length()-2; i++) { 
		if (sentence.substring(i, i+word.length()).equalsIgnoreCase(word)) { 
		count++; 
		} 
		} 
		return count; 
		} 
	public static int countOccurance1 (String word, String sentence) { 

		Pattern pattern = Pattern.compile(word ,Pattern.CASE_INSENSITIVE); 

		Matcher matcher = pattern.matcher(sentence); 

		int count = 0; 
		while (matcher.find()) 
		count++; 

		return count; 
		}
}
