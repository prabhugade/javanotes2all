package com.javanotes2all.java.string;

public class EscapeSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s="\\\\abc";
		System.out.println(s);
		String s1="\\s\\s";
		System.out.println(s1.replace("\\", "\\\\"));
	}

}
