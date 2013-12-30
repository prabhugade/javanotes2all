package com.javanotes2all.java.string;

import java.util.Arrays;

public class StringToCharArray {

	public static void main(String[] args) {

		String string = "javanotes2all";

		char[] charArray = string.toCharArray();

		System.out.println("String is:" + string + " Character Array : "
				+ Arrays.toString(charArray));
	}

}
