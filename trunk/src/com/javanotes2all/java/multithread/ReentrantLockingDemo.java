package com.javanotes2all.java.multithread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
 
public class ReentrantLockingDemo {
 
    final Lock lock = new ReentrantLock();
 
    public static void main(final String... args) {
        new  ReentrantLockingDemo().go();
    }
 
    private void go() {
        new Thread(newRunable(), "Thread1").start();
        new Thread(newRunable(), "Thread2").start();
        new Thread(newRunable(), "Thread3").start();
        new Thread(newRunable(), "Thread4").start();
        new Thread(newRunable(), "Thread5").start();
    }
 
    private Runnable newRunable() 
    {
    	return new Runnable() 
    	{
    		@Override
    		public void run() 
    		{
    			do 
    			{
    				try 
    				{

    					if (lock.tryLock(500, TimeUnit.MILLISECONDS)) 
    					{
    						try {

    							System.out.println("locked thread "
    									+ Thread.currentThread().getName());

    							Thread.sleep(1000);

    						} finally {
    							lock.unlock();
    							System.out.println("unlocked locked thread "
    									+ Thread.currentThread().getName());

    						}
    						break;
    					} else {
    						System.out.println("unable to lock thread "
    								+ Thread.currentThread().getName()
    								+ " will re try again");
    					}
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
    			} while (true);
    		}
    	};
    }
}