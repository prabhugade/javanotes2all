package com.javanotes2all.java.loops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class onlinetest {

    public static Change getCorrectChange(int cents) 
    {
    	int dollers=cents/100;
    	int remcents=(cents%100);
    	int quarters=remcents/25;
    		remcents=remcents%25;
    	int dimes=remcents/10;
    		remcents=remcents%10;
    	int nickels=remcents/5;
    	int fcents=remcents%5;
    	
       Change change=new Change(dollers,quarters,dimes,nickels,fcents);
       return change;
    }
    public static void main(String a[])
    {
    	/*Change change=onlinetest.getCorrectChange(164);
    	System.out.println(change.getDollars());
    	System.out.println(change.getQuarters());
    	System.out.println(change.getDimes());
    	System.out.println(change.getNickels());
    	System.out.println(change.getCents());
    	int p[]={-2,1,-2,5,-4,3};*/
    	//System.out.println(onlinetest.removeDuplicates(p).length);
    	
    	//System.out.println("\n\n"+onlinetest.getCountOfOnes(6));
    	//System.out.println(onlinetest.retainPositiveNumbers(p)[2]);
    	System.out.println("\n"+onlinetest.countAlmostPrimeNumbers(3, 11));
    }
    // Please do not change this interface
    interface ListNode {
        int getItem();
        ListNode getNext();
        void setNext(ListNode next);
    }
    
    public static double getProbability(int Y, int X) {
        /*
          If you roll Y standard six-sided dice, what’s the probability that you get at least X 4s?
          To calculate that you should divide the number of comibnations with X or more 4s
          by the total number of possible combinations.
         */
    	if(Y<X)
    		return 0;
    	if(Y==X)
    		return 1/36;
    	if(Y>X)
    	{
    		int p=Y-X;
    		
    	}
    	return 0;
    }
    

    public static ListNode reverse(ListNode node) {
        /*
          Please implement this method to
          reverse a given linked list.
         */
    	
    	if (node == null) return null; // first question

        if (node.getNext() == null) return node; // second question

        // third question - in Lisp this is easy, but we don't have cons
        // so we grab the second element (which will be the last after we reverse it)

        ListNode secondElem = node.getNext();
        // then we reverse everything from the second element on
        ListNode reverseRest = reverse(secondElem);

        // then we join the two lists
        secondElem.setNext(node);

        return reverseRest;
    }
    
    
    
    public static Set<Object> getIntersection(Set<Object> a, Set<Object> b) {
        /*
          Please implement this method to
          return a Set equal to the intersection of the parameter Sets
          The method should not chage the content of the parameters.
         */
    	Set<Object> set=new HashSet<Object>();
    	Iterator<Object> it=a.iterator();
    	while(it.hasNext())
    	{
    		Object o=it.next();
    		if(b.contains(o)&&!set.contains(o))
    			set.add(o);
    			
    	}
    	
    	return set;
    }
    
    
    
    public static int getClosestToZero(int[] a) {
        /*
          Please implement this method to
          return the number in the array that is closest to zero.
          If there are two equally close to zero elements like 2 and -2
          - consider the positive element to be "closer" to zero.
         */
    	for(int p=0;p<a.length;p++)
    	{
    		if(a[p]>0)
    			return a[p];
    	}
    	return 0;
    }
    
    
 // Please do not change this interface
    public static interface Node {
        int getValue();
        List<Node> getChildren();
    }


    public static double getAverage(Node root) {
        /*
          Please implement this method to
          return the average of all node values (Node.getValue()) in the tree.
         */
    	double result=0;
    	List<Node> list=root.getChildren();
    	for(int p=0;p<list.size();p++)
    	{
    		result+=list.get(p).getValue();
    	}
    	return result;
    }
    
    public static int[] retainPositiveNumbers(int[] k) 
    {
       	ArrayList<Integer> list=new ArrayList<Integer>();
       	for(int p=0;p<k.length;p++)
       	{
       		if(!list.contains(k[p])&&k[p]>0)
       		{
       			list.add(k[p]);
       		}
       	}
       	int[] ints = new int[list.size()];
           int i = 0;
           for (Integer n : list) {
               ints[i++] = n;
           }
           Arrays.sort(ints);
           return ints;
    }
    public static int countAlmostPrimeNumbers(int from, int to) {
        /*
          A prime number is a natural number that has exactly two distinct natural number divisors,
          which are 1 and the prime number itself.
          The first prime numbers are: 2, 3, 5, 7, 11, 13.

          Almost prime numbers are the non-prime numbers
          which are divisible by only a single prime number.

          Please implement this method to
          return the number of almost prime numbers within the given range (inclusively).
         */
    	int result=0;
    	if(from<=2)
    	{
    		result++;
    		from=3;
    	}
    	
    	while(from<=to)
    	{
    		boolean check=true;
    		for(int p=2;p<from;p++)
    		{
    			if(from%p==0)
    				check=false;
    		}
    		if(check)
    			result++;
    		from++;
    	}
    	return result;
    }
    public static int getCountOfOnes(int n) 
    {
    	char[] s=Integer.toBinaryString(n).toCharArray();
    	int result=0;    
    	for(int p=0;p<s.length;p++)
    	{
    		result+=Integer.parseInt(s[p]+"");
    	}
       return result;
    }
    public static int[] removeDuplicates(int[] a) {
        int k[]={2,1,3,4,1};
      	ArrayList<Integer> list=new ArrayList<Integer>();
      	for(int p=0;p<k.length;p++)
      	{
      		if(!list.contains(k[p]))
      		{
      			list.add(k[p]);
      		}
      	}
      	int[] ints = new int[list.size()];
          int i = 0;
          for (Integer n : list) {
              ints[i++] = n;
          }
          return ints;
      }
    // Please do not change this class
    static class Change {
        private final int _dollars;  //100 cents
        private final int _quarters; //25 cents
        private final int _dimes; // 10 cents
        private final int _nickels; // 5 cents
        private final int _cents; // 1 cent


        public Change(int dollars, int quarters, int dimes, int nickels, int cents) {
            _dollars = dollars;
            _quarters = quarters;
            _dimes = dimes;
            _nickels = nickels;
            _cents = cents;
        }


        public int getDollars() {
            return _dollars;
        }


        public int getQuarters() {
            return _quarters;
        }


        public int getDimes() {
            return _dimes;
        }


        public int getNickels() {
            return _nickels;
        }


        public int getCents() {
            return _cents;
        }
    }


}
