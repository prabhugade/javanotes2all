package com.javanotes2all.java.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class MethodInvocationReflection {

	public static void main(String args[]) {
	       Class loadedList = null;
	       List list = null;
	       try {
	            //loading class dynamically using reflection
	            loadedList = Class.forName("java.util.ArrayList");
	            list = (List) loadedList.newInstance();
	          
	            //calling method using interface on reflective instance
	            list.add("abc");
	            list.add("bcd");

	        } catch (InstantiationException ex) {
	            System.err.println("Not able to create Instance of Class");
	        } catch (IllegalAccessException ex) {
	            System.err.println("Not able to access Class");
	        } catch (ClassNotFoundException ex) {
	            System.err.println("Not able to find Class");
	        }
	    
	       try {
	            //getting method instance reflectively
	            Method m = loadedList.getMethod("size", (Class[]) null);
	          
	            //calling method in java using reflection dynamically
	            Object size = m.invoke(list, (Object[]) null);
	            System.out.println("Result of dynamically invoking method in Java, Size: " + size);

	        } catch (NoSuchMethodException ex) {
	            System.err.println("Not able to find Method on class");
	            ex.printStackTrace();
	        } catch (SecurityException ex) {
	            System.err.println("Security Exception raised");
	            ex.printStackTrace();
	        } catch (IllegalAccessException ex) {
	            System.err.println("Not able to access method ");
	            ex.printStackTrace();
	        } catch (IllegalArgumentException ex) {
	            System.err.println("Incorrect supplied arguments");
	            ex.printStackTrace();
	        } catch (InvocationTargetException ex) {
	            System.err.println("Not able to invoke method by String in Java");
	            ex.printStackTrace();
	        }
	    }	
}
