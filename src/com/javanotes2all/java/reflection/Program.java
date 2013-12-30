package com.javanotes2all.java.reflection;

class AClass {
	  public AClass() {
	    System.out.println("AClass's Constructor");
	  }
	  static { 
	    System.out.println("static block in AClass");
	  }
	}

	public class Program { 
	  public static void main(String[] args) {
	    try { 
	      System.out.println("The first time calls forName:");
	      Class c   = Class.forName("com.javanotes2all.java.reflection.AClass"); 
	      System.out.println("1");
	      AClass a = (AClass)c.newInstance();

	      System.out.println("The second time calls forName:");
	      Class c1 = Class.forName("com.javanotes2all.java.reflection.AClass");
	      //System.out.println("1");
	      //AClass a1 = (AClass)c.newInstance();

	    } catch (ClassNotFoundException e) {
	    } catch (InstantiationException e) {
	    } catch (IllegalAccessException e) {
	    }
	        
	  }
	}