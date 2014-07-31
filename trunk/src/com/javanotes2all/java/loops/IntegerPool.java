package com.javanotes2all.java.loops;

public class IntegerPool {

	/*
	 * Java caches the integer objects in the range -128 to 127.
	 *  So, when you try to assign a value in this range to a wrapper object, 
	 *  the boxing operation will invoke Integer.valueOf method and in turn it will assign a reference to the object already in the pool.
	 *  
	 * On the other hand, if you assign a value outside this range to a wrapper reference type, Integer.valueOf will create a new Integer object for that value.
	 *  And hence, comparing the reference for Integer objects having value outside this range will give you false
	 */
	public static void main(String[] args) {
	Integer i=127;// Equivalent to `Integer.valueOf(127)
	Integer i1=127;
	Integer i2=new Integer(127);
	// Equivalent to `Integer.valueOf(128)`
	// returns `new Integer(128)` for value outside the `Range - [-128, 127]`
	Integer a=128;
	Integer b=128;
	
	System.out.println(i==i1); // true, reference pointing to same literal
	
	System.out.println(a==b);// false, reference pointing to different objects
	
	System.out.println(i1==i2); //false, because we create object manually for i2.
	
	System.out.println(i2.toString()==i1.toString());
	System.out.println(i2.toString().hashCode()+" "+i1.toString().hashCode());
	System.out.println("127".hashCode());
	System.out.println(i2.toString()==i1.toString());
	
	
	
	// Prints "true".
	int i11 = 1;
	Integer i21 = new Integer(i11);
	System.out.println(i11 == i21);

	// Prints "false".
	int i12 = 0;
	Integer i22 = new Integer(i12);
	i12 += 1;
	System.out.println(i12 == i22);
	
	// Prints "true".
	int i13 = 0;
	i13 += 1;
	Integer i23 = new Integer(i13);
	System.out.println(i13 == i23);
	}

}
