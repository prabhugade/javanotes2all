package com.javanotes2all.java.loops;

public class SpaceRepeatedlyEveryTwocharacters {

	public static void main(String[] args) {
		String s = "919533051699";
		s = s.substring(0,4).replaceAll("..", "$0 ")+s.substring(4,s.length());
		System.out.println("+"+s);
	}
}
