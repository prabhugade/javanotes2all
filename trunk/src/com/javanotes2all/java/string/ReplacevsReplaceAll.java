package com.javanotes2all.java.string;

public class ReplacevsReplaceAll {

	public static void main(String[] args) {
		
		/*
		 * Example1- For normal string both are same
		 */
		String s="javanotes2all";
		
		System.out.println("For one character replace");
		System.out.println("replace():   "+s.replace("a", "-"));
		System.out.println("replaceAll():   "+s.replaceAll("a", "-"));
		
		System.out.println("\nFor more characters replace");
		System.out.println("replace():   "+s.replace("av", "-"));
		System.out.println("replaceAll():   "+s.replaceAll("av", "-"));
		
		/*
		 * Example2- For Regular expressions both are different
		 */
		s="javanotes2all_$_prabhu _java $ notes";
		
		System.out.println("\nFor Regular expressions");
		/*
		 * replace method replaces all characters match
		 */
		System.out.println("replace():   "+s.replace("_$_", "-"));
		/*
		 * This is not replacing 
		 */
		System.out.println("replaceAll():   "+s.replaceAll("_$_", "-"));
		
		/*
		 * This is replacing characters 
		 */
		System.out.println("replaceAll():   "+s.replaceAll("\\_\\$\\_", "-"));
		
	}

}
