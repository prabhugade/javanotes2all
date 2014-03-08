package com.javanotes2all.java.foramt;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Doubleformat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("====approach1====");
		double price = 2.5000000009;
		String s = String.format("%.2f", price);
		System.out.println(s);
		
		System.out.println("====approach1====");
		DecimalFormat formatter = new DecimalFormat("Rs0.00");
		System.out.println(formatter.format(price)); // print: $2.50
		System.out.println("====approach3====");
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
		System.out.println(currencyFormatter.format(price));
	}

}
