package com.javanotes2all.java.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShopReceipt {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the no. of types of Items Purchased: ");
		byte z=Byte.parseByte(in.readLine());
		String n[]=new String[z];
		byte q[]=new byte[z];
		float r[]=new float[z];
		float pr[]=new float[z];
		System.out.println("PLEASE ENTER::");
		for(byte i=0;i<z;i++)
		{
		pr[i]=0;
		System.out.print("Name of Item: ");
		n[i]=in.readLine();
		System.out.print("Rate of Item: ");
		r[i]=Float.parseFloat(in.readLine());
		System.out.print("Quantity of Items: ");
		q[i]=Byte.parseByte(in.readLine());
		pr[i]=r[i]*q[i];
		}
		double t=0;
		for(byte i=0;i<z;i++)
		t+=pr[i];
		for(byte i=0;i<z;i++)
		System.out.print("Item: "+n[i]+"\tQuantity: "+q[i]+"\tTotal Cost: "+pr[i]+"\n");
		System.out.print("\nBill:"+t);
		if(t>=100&&t<500)
		System.out.print("\nGift::\nA Key Ring");
		else if(t>=500&&t<1000)
		System.out.print("\nGift::\nA Leather Purse");
		else if(t>=1000)
		System.out.print("\nGift::\nA Pocket Calculator"); 

	}

}
