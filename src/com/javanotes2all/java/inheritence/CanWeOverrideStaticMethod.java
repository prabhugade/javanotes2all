package com.javanotes2all.java.inheritence;

public class CanWeOverrideStaticMethod 
{
	public static void main(String args[]) 
	{
	Screen scrn = new ColorScreen();
    //if we can  override static , 
	//this should call method from Child class
	//IDE will show warning, static method should be called from classname
    scrn.staticMethod(); 
  
    scrn.nonStaticMethod();
    }  
  
}

class Screen
{
  
    /*
     * public static method which can not be overridden in Java
     */
    public static void staticMethod()
    {
     System.out.println("Static method from parent class");
    }
    
    /**
     * non static method
     */
    public void nonStaticMethod()
    {
    System.out.println("non-Static method from parent class");
    }
}

class ColorScreen extends Screen{
    /*
     * static method of same name and method signature as existed in super
     * class, this is not method overriding instead this is called
     * method hiding in Java
     */
    public static void staticMethod()
    {
    System.err.println("Overridden static method in Child Class in Java");
    }
    
    /**
     * non static method
     */
    public void nonStaticMethod()
    {
    System.out.println("non-Static method from Child class");
    }
}
