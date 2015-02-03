package com.javanotes2all.java.validations;

public class EmailidValidation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String emailid="prabhu@silicaminds.com";
		if(emailid.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
		{
			System.out.println("Valid Emailid");
		}else
			System.out.println("InValid Emailid");
		
		

	}

}
