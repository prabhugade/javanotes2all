package com.javanotes2all.java.string;

public class CharToString 
{

	public static void main(String[] args) {
		char ch = 'J';

		String string1 = Character.toString(ch);

		String string2 = String.valueOf(ch);

		System.out.println("character is : " + ch
				+ ". String using String.valueOf(char c):  " + string2);

		System.out.println("character is : " + ch
				+ ". String using Character.toString(char c):  " + string1);
	}
}
