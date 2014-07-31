package com.javanotes2all.java.loops;

public class SwapTwonumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x=10;
		int y=20;
		System.out.println(x+" "+y);
		//x ^=y;
		//System.out.println(x+" "+y);
		/*x ^=y;
		y ^=x;
		x ^=y;
		System.out.println(x+" "+y);
		y ^=x ^=y;
		System.out.println(x+" "+y);
		x ^=y;
		System.out.println(x+" "+y);*/
		x = x ^= y ^=x ^=y;
		System.out.println(x+" "+y);
	}

}
