package com.javanotes2all.java.problems;

import java.math.BigDecimal;

public class ProblemWithDouble {

	public static void main(String[] args) 
	{
		System.out.println("--- Normal Print-----");
		System.out.println(2.00 - 1.1);
		System.out.println(2.00 - 1.2);
		System.out.println(2.00 - 1.3);
		System.out.println(2.00 - 1.4);
		System.out.println(2.00 - 1.5);
		System.out.println(2.00 - 1.6);
		System.out.println(2.00 - 1.7);
		System.out.println(2.00 - 1.8);
		System.out.println(2.00 - 1.9);
		System.out.println(2.00 - 2);

		System.out.println("--- BigDecimal-----");
		System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.1")));
		System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.2")));
		System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.3")));
		System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.4")));
		System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.5")));
		System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.6")));
		System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.7")));
		System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.8")));
		System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.9")));
		System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("2"))); 

	}

}
