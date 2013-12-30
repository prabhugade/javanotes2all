package com.javanotes2all.java.security;

import org.apache.commons.codec.binary.Base64;
//commons-codec-1.4.jar file required 
public class EncAndDec { 
	public static void main(String[] args) { 
		try { 
			String clearText = "prabhugade"; 
			String encodedText; 

			// Base64 
			encodedText = new String(Base64.encodeBase64(clearText.getBytes())); 
			System.out.println("Encoded: " + encodedText); 
			System.out.println("Decoded:" + new String(Base64.decodeBase64(encodedText.getBytes()) )); 

		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 
} 