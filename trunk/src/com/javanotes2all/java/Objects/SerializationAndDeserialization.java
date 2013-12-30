package com.javanotes2all.java.Objects;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationAndDeserialization 
{
	public static void main(String[] args) 
	{
	    Phone phone01 = Phone.getNewPhone("prabhu", "1234567890");
		Phone phone02 = Phone.getBlankPhone();
		    
		    phone01.printNumber(); // Print start value
		    
		    try {
		      ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream("/home/prabhu/project/object.dat"));
		      out.writeObject(phone01); // Serialize Object
		      out.close();
		    } catch(Exception e){
		      e.printStackTrace();
		    }

		    phone01.setNumber("0987654321"); // Change Object 
		    
		    try {
		      ObjectInputStream in = new ObjectInputStream( new FileInputStream("/home/prabhu/project/object.dat"));
		      phone02 = (Phone) in.readObject();
		      in.close();
		    } catch(Exception e){
		      e.printStackTrace();
		    }
		    
		    phone01.printNumber(); // Print Changed Object
		    phone02.printNumber(); // Print Original Object
		    
	}
}
class Phone implements Serializable 
{
	private String name;
	private String number;

	private Phone(){
		this.name = "";
		this.number = "";
	}

	private Phone(String name, String number){
		this.name = name;
		this.number = number;
	}

	public static Phone getNewPhone(String name, String number){
		Phone newPhone = new Phone(name, number);
		return newPhone;
	}

	public static Phone getBlankPhone(){
		Phone newPhone = new Phone();
		return newPhone;
	}

	public void setNumber(String number){
		this.number = number;  
	}

	public void printNumber(){
		System.out.println("Phone Entry: " + this.name + " - " + this.number);    
	}

}
