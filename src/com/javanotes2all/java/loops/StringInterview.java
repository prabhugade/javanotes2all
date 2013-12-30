package com.javanotes2all.java.loops;

public class StringInterview {

	public static void main(String[] args) 
	{
		new StringInterview().stringRotateLogic(new StringBuilder("javanotes2all"));
	}
	public void stringRotateLogic(StringBuilder str)
	{
		System.out.println(str);
		String temp=str.toString();
		boolean check=true;
		while(check)
		{
			str=str.insert(str.length(), str.charAt(0)).deleteCharAt(0);
			System.out.println(str);
			if(str.toString().equals(temp))
			{
				check=false;
			}
		}
	}

}
